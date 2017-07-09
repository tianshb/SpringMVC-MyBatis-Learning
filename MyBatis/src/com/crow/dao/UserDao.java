package com.crow.dao;

import com.crow.po.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by CrowHawk on 17/3/16.
 */
public interface UserDao {
    public void insertUser(User user) throws Exception;
    public User findUserById(int id) throws Exception;
    public List<User> findUserByName(String name) throws Exception;//模糊查找
    public void deleteUser(int id) throws Exception;
}
