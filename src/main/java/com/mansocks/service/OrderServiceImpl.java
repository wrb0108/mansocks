package com.mansocks.service;

import com.mansocks.dao.OrderDao;
import com.mansocks.entity.Order;
import com.mansocks.entity.OrderDet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Override
    public void add(Order order) {
        orderDao.add(order);
    }

    @Override
    public void adddet(OrderDet orderDet) {
        orderDao.adddet(orderDet);
    }

    @Override
    public List<Order> order(Integer userid) {
        return  orderDao.order(userid);
    }

    @Override
    public List<OrderDet> orderdet(String ordernum) {
        return orderDao.orderdet(ordernum);
    }

    @Override
    public Double payment(String ordernum) {
        return orderDao.payment(ordernum);
    }

    @Override
    public void delOrder(String orernum) {
        orderDao.delOrder(orernum);
    }

    @Override
    public void delOrderDet(String orernum) {
        orderDao.delOrderDet(orernum);
    }

    @Override
    public void update(String ordernum) {
        orderDao.update(ordernum);
    }

    @Override
    public int orderstatu(String ordernum) {
        return orderDao.orderstatu(ordernum);
    }
}
