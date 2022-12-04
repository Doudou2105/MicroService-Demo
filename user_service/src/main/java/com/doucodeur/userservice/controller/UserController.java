package com.doucodeur.userservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.doucodeur.userservice.model.User;
import com.doucodeur.userservice.service.UserServiceImp;
import com.doucodeur.userservice.vo.ResponseTemplateVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImp userService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers(){
        return userService.getUsers();
    }


    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable final Long userId){
        userService.deleteUser(userId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody final User user){
        return userService.saveUser(user);
    }
    
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public  ResponseTemplateVo getUserWithDepartment(@PathVariable final Long userId){
        return userService.getUserWithDepartment(userId);
    }
}