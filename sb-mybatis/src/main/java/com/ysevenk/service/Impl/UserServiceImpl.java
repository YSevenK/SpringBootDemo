package com.ysevenk.service.Impl;

import com.ysevenk.entity.Users;
import com.ysevenk.mapper.UserMapper;
import com.ysevenk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Users> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public Users getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
