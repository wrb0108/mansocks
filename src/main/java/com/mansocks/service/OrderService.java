package com.mansocks.service;

import com.mansocks.entity.Order;
import com.mansocks.entity.OrderDet;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderService {
    //添加订单
    void add(Order order);

    //添加订单详情
    void adddet(OrderDet orderDet);

    //查看所有订单(总订单)
    List<Order> order(Integer userid);

    //查看所有订单(订单详情)
    List<OrderDet> orderdet(String ordernum);

    //付款页面
    Double payment(String ordernum);

    //删除订单
    void delOrder(String orernum);
    //删除订单详情
    void delOrderDet(String orernum);
    //付款改状态
    void update(String ordernum);
    //查看订单状态
    int orderstatu(String ordernum);
}
