package com.ysevenk.controller;

import com.ysevenk.entity.Users;
import com.ysevenk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Users getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
}
