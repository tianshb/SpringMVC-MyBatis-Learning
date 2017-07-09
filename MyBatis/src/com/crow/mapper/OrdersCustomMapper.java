package com.crow.mapper;

import com.crow.po.Orders;
import com.crow.po.OrdersCustom;
import com.crow.po.User;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

/**
 * Created by CrowHawk on 17/3/21.
 */
public interface OrdersCustomMapper {
    public List<OrdersCustom> findOrdersUser();

    public List<Orders> findOrdersUserResultMap();

    public List<Orders> findOrderAndDetailResultMap();

    public List<User> findUserAndItemsResultMap();

    //查询订单关联查询用户，用户信息是延迟加载
    public List<Orders> findOrdersUserLazyLoading()throws Exception;
}
