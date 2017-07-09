package com.crow.mapper;

import com.crow.po.User;
import com.crow.po.UserCustom;
import com.crow.po.UserQueryVo;

import java.util.List;

/**
 * Created by CrowHawk on 17/3/17.
 */
public interface UserMapper {
    //用户信息综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    //用户信息综合查询总数
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    //根据id查询用户信息
    public User findUserById(int id) throws Exception;

    //根据id查询用户信息，使用resultMap输出
   // public User findUserByIdResultMap(int id) throws Exception;


    //根据用户名列查询用户列表
    public List<User> findUserByName(String name)throws Exception;

    public List<User> findUserBySex(int sex)throws Exception;

    public List<User> findUserByAddress(String address)throws Exception;

    //插入用户
    public void insertUser(User user)throws Exception;

    //删除用户
    public default void deleteUser(int id) throws Exception {

    }
}
