package com.crow.ssm.mapper;

import com.crow.ssm.po.User;
import com.crow.ssm.po.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by CrowHawk on 17/4/3.
 */
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
