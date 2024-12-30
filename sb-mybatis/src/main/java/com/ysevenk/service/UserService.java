package com.ysevenk.service;

import com.ysevenk.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();

    Users getUserById(int id);
}
