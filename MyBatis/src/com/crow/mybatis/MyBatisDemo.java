package com.crow.mybatis;

import com.crow.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by CrowHawk on 17/3/15.
 */
public class MyBatisDemo {
    //根据ID查询用户信息，得到一条记录结果
    @Test
    public void findUserByIdTest() throws IOException{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);//获取配置文件流
        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById",1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void findUserByNameTest() throws IOException{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("test.findUserByName", "小明");
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    public void insertUser() throws IOException{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("老王");
        user.setSex("1");
        user.setAddress("江苏镇江");
        user.setBirthday(new Date());
        sqlSession.insert("test.insertUser", user);
        // 提交事务
        sqlSession.commit();
        // 获取用户信息主键
        System.out.println(user.getId());
        sqlSession.close();
    }
}
