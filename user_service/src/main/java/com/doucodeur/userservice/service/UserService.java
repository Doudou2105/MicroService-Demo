package com.doucodeur.userservice.service;

import java.util.List;

import com.doucodeur.userservice.model.User;

public interface UserService {
    
    List<User> getUsers();
    User saveUser(User user);
    void deleteUser(Long userId);
}