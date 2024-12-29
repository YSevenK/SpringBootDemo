package com.ysevenk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private Date createTime;
    private Date lastLoginTime;
}
