package com.example.service;

import com.example.entity.User;
import com.example.utils.Md5Util;

import java.util.List;
/*
 * @description:
 * @author 曹红亮
 * @date 2022/2/24 17:49
 */
public class UserService {
    public List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User signIn(String account, String password) {
        for (User user : userList) {
            if (user.getAccount().equals(account) && user.getPassword().equals(Md5Util.crypt(password))) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        User user = new UserService().signIn("13951905171", Md5Util.crypt("111"));
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("登录失败");
        }
    }
}
