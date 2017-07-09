package com.crow.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by CrowHawk on 17/3/15.
 */
public class JdbcTest {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:mysql://localhost:3306/OrderForm";
        String username = "root";
        String password = "wyj";
        Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
        Connection conn = DriverManager.getConnection(url, username, password);////通过驱动管理类获取数据库链接
        Statement statement = conn.createStatement();//获取用于向数据库发送sql语句的statement
        String sql = "select * from user";//定义sql语句
        ResultSet resultSet = statement.executeQuery(sql);//向数据库发sql,并获取结果集
        while (resultSet.next()){//取出结果集的数据
            System.out.println("id = " + resultSet.getObject("id"));
            System.out.println("username = " + resultSet.getObject("username"));
            System.out.println("birthday = " + resultSet.getObject("birthday"));
            System.out.println("sex = " + resultSet.getObject("sex"));
            System.out.println("address = " + resultSet.getObject("address"));
        }
        //释放资源
        resultSet.close();
        statement.close();
        conn.close();
    }
}
