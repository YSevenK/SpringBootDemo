package com.ysevenk.service;

import com.ysevenk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    private static final String USER_KEY_PREFIX = "user:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 保存用户信息到 Redis 中（支持链式编程）
    // 设置了用户信息过期时间 10 单位 秒
    public void saveUser(User user) {
        redisTemplate.opsForValue().set(USER_KEY_PREFIX + user.getId(), user, 10, TimeUnit.SECONDS);
    }

    // 从 Redis 中获取用户信息
    public User getUserById(String id) {
        return (User) redisTemplate.opsForValue().get(USER_KEY_PREFIX + id);
    }

    // 删除 Redis 中的用户信息
    public void deleteUserById(String id) {
        redisTemplate.delete(USER_KEY_PREFIX + id);
    }
}
