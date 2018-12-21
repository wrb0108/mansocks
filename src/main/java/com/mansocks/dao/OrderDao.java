package com.mansocks.dao;

import com.mansocks.entity.Order;
import com.mansocks.entity.OrderDet;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    //添加订单
    @Insert("insert into `order` (ordernum,userid,size,orderstatus,allmoney,addressid) values (#{ordernum},#{userid},#{size},#{orderstatus},#{allmoney},#{addressid})")
    void add(Order order);

    //添加订单详情
    @Insert("insert into orderdet (ordernum,commodityid,commoditynum,money,colorid,typeid) values (#{ordernum},#{commodityid},#{commoditynum},#{money},#{colorid},#{typeid})")
    void adddet(OrderDet orderDet);

    //查看所有订单(总订单)
    @Select("select ordernum,date,size,orderstatus,allmoney,`order`.addressid,username,phone from `order` left join address on `order`.addressid=address.addressid  where `order`.userid=#{userid}")
    List<Order> order(Integer userid);

    //查看所有订单(订单详情)
    @Select("select commodity.`name`,color.img,color.color,type.type,orderdet.money from commodity LEFT JOIN color ON commodity.commodityid=color.commodityid LEFT JOIN type on commodity.commodityid=type.commodityid  LEFT JOIN orderdet ON orderdet.commodityid=commodity.commodityid where orderdet.ordernum=#{ordernum}")
    List<OrderDet> orderdet(String ordernum);

    //付款页面
    @Select("select allmoney from `order` where ordernum=#{ordernum}")
    Double payment(String ordernum);

    //删除订单
    @Delete("delete from  `order` where ordernum=#{ordernum}")
    void delOrder(String orernum);
    //删除订单详情
    @Delete("delete from orderdet where ordernum=#{ordernum}")
    void delOrderDet(String ordernum);

    //确认付款
    @Update("update `order` set orderstatus=1  where ordernum=#{ordernum}")
    void update(String ordernum);
    //查看订单状态
    @Select("select orderstatus from `order` where ordernum=#{ordernum}")
    int orderstatu(String ordernum);
}
