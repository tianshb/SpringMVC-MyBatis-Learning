package com.crow.test;

import com.crow.dao.UserDao;
import com.crow.dao.UserDaoImpl;
import com.crow.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by CrowHawk on 17/3/17.
 */
public class UserDaoImplTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserByIdTest() throws Exception{
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void findUserByNameTest() throws Exception{
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        List<User> userList = userDao.findUserByName("小明");
        System.out.println(userList);
    }
}
