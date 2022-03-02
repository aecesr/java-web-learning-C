package com.chl.web.exercise.service;

import com.chl.web.exercise.entity.Brand;
import com.chl.web.exercise.mapper.BrandMapper;
import com.chl.web.exercise.util.SqlSessionFactoryUtil;
import jakarta.servlet.annotation.WebServlet;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @program: java-web-learning-C
 * @description:
 * @Author: 曹红亮
 * @create: 2022-03-01 16:39
 **/
@Slf4j
@WebServlet
public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();


     // 查询所有

    public List<Brand> selectAll() {
        //1. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //2. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3. 调用方法
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }


      //添加

    public void add(Brand brand) {
        //1. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //2. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3. 调用方法
        mapper.add(brand);
        //4. 提交事务
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }


     //根据id查询

    public Brand selectById(int id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }


   //修改
    public void update(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }
    public void delete(int id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
