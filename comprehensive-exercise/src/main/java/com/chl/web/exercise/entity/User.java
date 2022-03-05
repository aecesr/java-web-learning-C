package com.chl.web.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: java-web-learning-C
 * @description: 用户类
 * @Author: 曹红亮
 * @create: 2022-02-28 15:35
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
//    主键id
    private Integer id;
//    用户名
    private String username;
//    密码
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
