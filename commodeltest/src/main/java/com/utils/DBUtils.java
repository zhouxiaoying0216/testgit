package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.Reader;

public class DBUtils {

    public static SqlSession getSqlSession() throws IOException {
        //读取mybqatis_config.xml资源文件
        Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
        System.out.println("读取文件成功");

        //加载资源文件，并获取SqlSessionFactory用于数据库连接
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        System.out.println("读取文件成功");

        //返回sqlSession用于数据库操作
        SqlSession sqlSession = sqlSessionFactory.openSession();


        return sqlSession;
    }

    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = DBUtils.getSqlSession();

    }
}
