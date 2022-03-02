package com.chl.web.exercise.mapper;

import com.chl.web.exercise.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/*
 * @description:
 * @author 曹红亮
 * @date 2022/2/28 20:39
 */
public interface UserMapper {
//    根据用户名和密码查询用户对象
    @Select("SELECT * FROM tb_user WHERE username = #{username} AND password = #{password}")
    User findUser(@Param("username")String username, @Param("password")String password);

   //根据用户名查询用户对象

    @Select("SELECT * FROM tb_user WHERE username = #{username} ")
    User selectByUsername(String username);

    @Select("SELECT * FROM tb_user WHERE id = #{name} ")
    User selectByname(String name);

     // 添加用户

    @Insert("INSERT INTO tb_user VALUES (null,#{username},#{password}) ")
    void add(User user);

}
