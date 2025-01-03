package com.ysevenk.mapper;

import com.ysevenk.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 查询所有用户
    List<Users> getAllUsers();

    // 根据id查询用户
    Users getUserById(int id);

}
