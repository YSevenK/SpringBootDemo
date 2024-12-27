package com.ysevenk.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysevenk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    /*private static final String USER_KEY_PREFIX = "user:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 保存用户信息到 Redis 中（支持链式编程）
    // 设置了用户信息过期时间 100 单位 秒
    public void saveUser(User user) {
        redisTemplate.opsForValue().set(USER_KEY_PREFIX + user.getId(), user, 100, TimeUnit.SECONDS);
    }

    // 从 Redis 中获取用户信息
    public User getUserById(String id) {
        return (User) redisTemplate.opsForValue().get(USER_KEY_PREFIX + id);
    }

    // 删除 Redis 中的用户信息
    public void deleteUserById(String id) {
        redisTemplate.delete(USER_KEY_PREFIX + id);
    }*/

    /**
     * 写入时手动把对象序列化为json，读取时手动反序列化为对象
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void saveUser(User user) throws Exception {
        String userJson = objectMapper.writeValueAsString(user);
        stringRedisTemplate.opsForValue().set("user:" + user.getId(), userJson, 100, TimeUnit.SECONDS);
    }

    public User getUser(String userId) throws Exception {
        String userJson = stringRedisTemplate.opsForValue().get("user:" + userId);
        if (userJson == null) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        return objectMapper.readValue(userJson, User.class);
    }

    public void deleteUser(String userId) throws Exception {
        String key = "user:" + userId;
        stringRedisTemplate.delete(key);
    }
}
