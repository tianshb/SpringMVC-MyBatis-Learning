package com.crow.ssm.mapper;

import com.crow.ssm.po.Orders;
import com.crow.ssm.po.OrdersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by CrowHawk on 17/4/3.
 */
public interface OrdersMapper {
    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}
