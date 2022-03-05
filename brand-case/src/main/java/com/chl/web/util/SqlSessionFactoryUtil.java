package com.chl.web.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: java-web-learning-C
 * @description:
 * @Author: 曹红亮
 * @create: 2022-02-28 16:02
 **/

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;

    //静态代码块会随着类的加载自动执行，且只执行一次，在构造方法之前执行String resource = "mybatis-config. xml" ;
    static {
        String resoruce = "mybatis-config.xml";
        try {
            InputStream is = Resources.getResourceAsStream(resoruce);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
