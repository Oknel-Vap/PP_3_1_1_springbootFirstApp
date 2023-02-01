package com.first.springbootapp.service;

import com.first.springbootapp.model.User;
import com.first.springbootapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
    public void updateUser(User user) {
        userRepository.save(user);
    }
    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }
    public void removeUserById(Long id) {
        userRepository.deleteById(id);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
