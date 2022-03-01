package com.chl.web.exercise.service;

import com.chl.web.exercise.entity.User;
import com.chl.web.exercise.mapper.UserMapper;
import com.chl.web.exercise.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @program: java-web-learning-C
 * @description:
 * @Author: 曹红亮
 * @create: 2022-02-28 16:08
 **/

public class UserService {
//    获取SqlSessionFactory对象
    SqlSessionFactory factory= SqlSessionFactoryUtil.getSqlSessionFactory();
    private UserMapper mapper;

    public User login(String username, String password){
//        获取sqlSession
        SqlSession sqlSession= factory.openSession();
//        获取userMapper
        mapper = sqlSession.getMapper(UserMapper.class);
//        调用方法
        User user = mapper.findUser(username,password);
//        释放资源
        sqlSession.close();
        return user ;
    }
    public  boolean register(User user) {
        //1. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //2. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3. 判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());
        if (u == null) {
            // 用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u == null;
    }
}
