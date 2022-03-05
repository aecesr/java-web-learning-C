package com.chl.web.exercise.service;

import com.chl.web.exercise.entity.User;
import com.chl.web.exercise.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
/*
 * @description:
 * @author 曹红亮
 * @date 2022/2/28 21:03
 */
@Slf4j
class UserServiceTest {

    @Test
    void login() {
        UserService userService= new UserService();
        User user = userService.login("zhangsan","123");
        if (user != null) {
            log.info(String.valueOf(user));
        }
    }
    @Test
    public void getPath() throws IOException {

        //获取当前文件所在的路径
        String localPath = this.getClass().getResource("").getPath();
        System.out.println("localPath = " + localPath);
        //localPath = /C:/work/idea-WorkSpace/my-demo/demo-file/target/classes/com/zgd/demo/file/path/
    }
}