package com.ysevenk.controller;

import com.ysevenk.entity.User;
import com.ysevenk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // 保存用户
    @PostMapping
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User saved successfully!";
    }

    // 获取用户
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return "User deleted successfully!";
    }
}
