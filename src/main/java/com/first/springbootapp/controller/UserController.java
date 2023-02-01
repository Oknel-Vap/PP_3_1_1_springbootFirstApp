package com.first.springbootapp.controller;

import com.first.springbootapp.model.User;
import com.first.springbootapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ModelAttribute("newUser")
    public User getPerson(){
        return new User();
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("people",userService.getAllUsers());
        return "index";
    }

    @PostMapping("/")
    public String creat(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") Long id){
        userService.removeUserById(id);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("user") User user){

        userService.updateUser(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit (@ModelAttribute("id") Long id,Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }
}
