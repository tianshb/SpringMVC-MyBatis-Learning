package com.crow.test;

import com.crow.mapper.OrdersCustomMapper;
import com.crow.po.Orders;
import com.crow.po.OrdersCustom;
import com.crow.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by CrowHawk on 17/3/21.
 */
public class OrdersCustomMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        // 创建sqlSessionFactory

        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindOrdersUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);

        // 调用maper的方法
        List<OrdersCustom> list = ordersCustomMapper.findOrdersUser();

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void testFindOrdersUserResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);

        // 调用maper的方法
        List<Orders> list = ordersCustomMapper.findOrdersUserResultMap();

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void testFindOrderAndDetailResultMap() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        List<Orders> ordersList = ordersCustomMapper.findOrderAndDetailResultMap();
        System.out.println(ordersList);
        sqlSession.close();
    }

    @Test
    public void testfindUserAndItemsResultMap() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        List<User> userList = ordersCustomMapper.findUserAndItemsResultMap();
        System.out.println(userList);
        sqlSession.close();
    }

    // 查询订单关联查询用户，用户信息使用延迟加载
    @Test
    public void testFindOrdersUserLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();// 创建代理对象
        OrdersCustomMapper ordersMapperCustom = sqlSession
                .getMapper(OrdersCustomMapper.class);
        // 查询订单信息（单表）
        List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();

        // 遍历上边的订单列表
        for (Orders orders : list) {
            // 执行getUser()去查询用户信息，这里实现按需加载
            User user = orders.getUser();
            System.out.println(user);
        }

    }

}
