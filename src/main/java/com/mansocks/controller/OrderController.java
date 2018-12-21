package com.mansocks.controller;

import com.mansocks.entity.Order;
import com.mansocks.entity.OrderDet;
import com.mansocks.service.OrderService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Api("订单")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;


    @ApiOperation(value = "添加订单")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiResponses({@ApiResponse(code = 1, message = "操作成功"), @ApiResponse(code = 0, message = "操作失败"), @ApiResponse(code = 3, message = "权限不足")})
    @ApiImplicitParams({
    })
    public String add(@ModelAttribute Order order, HttpServletRequest request) {
        //生成订单号
        StringBuffer ordernum = new StringBuffer();
        for (int i = 0; i < 14; i++) {
            int num = (int) (Math.random() * 10);
            ordernum.append(num);
        }
        String ordernum1 = ordernum.toString();
        order.setOrdernum(ordernum1);
//     测试
//              OrderDet orderDet1=new OrderDet();
//              orderDet1.setCommodityid(11);
//              orderDet1.setCommodityname("11");
//              orderDet1.setMoney(11);
//              orderDet1.setTypeid("11");
//              orderDet1.setColorid("11");
//              orderDet1.setImg("11");

//               List<OrderDet> orderDetsa=new ArrayList<>();
//               orderDetsa.add(orderDet1);
//               request.setAttribute("cartlist",orderDetsa);

        //获取购物车所有商品
        List<OrderDet> orderDets = (List<OrderDet>) request.getAttribute("cartlist");

        //添加
        for (OrderDet orderDet : orderDets) {
            //
            orderDet.setOrdernum(ordernum1);
            orderService.adddet(orderDet);  //添加订单详情
        }
        orderService.add(order);

//******************15分钟后未付款删除订单*********************
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                int flag=orderService.orderstatu(ordernum1);
                if(flag==0){
                    orderService.delOrder(ordernum1);
                    orderService.delOrderDet(ordernum1);
                    cancel();
                }else {
                    cancel();
                }
            }
        };

        //创建一个timer实例
        Timer timer = new Timer();
        //创建一个MyTimerTask实例

        timer.schedule(timerTask, 900000);
        return "添加订单成功";
    }

    @ApiOperation(value = "删除订单")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 1, message = "操作成功"), @ApiResponse(code = 0, message = "操作失败"), @ApiResponse(code = 3, message = "权限不足")})
    @ApiImplicitParams({
    })
    public String del(String ordernum) {

        orderService.delOrder(ordernum);
        orderService.delOrderDet(ordernum);
        return "删除订单成功";
    }

    @ApiOperation(value = "付款页面总金额")
    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 1, message = "操作成功"), @ApiResponse(code = 0, message = "操作失败"), @ApiResponse(code = 3, message = "权限不足")})
    @ApiImplicitParams({
    })
    public Double payment(String ordernum) {
        return orderService.payment(ordernum);
    }

    @ApiOperation(value = "查看所有订单")
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 1, message = "操作成功"), @ApiResponse(code = 0, message = "操作失败"), @ApiResponse(code = 3, message = "权限不足")})
    @ApiImplicitParams({
    })
    public List<Order> select(Integer userid, HttpServletRequest request) {
        List<Order> orders = orderService.order(userid);
        List<OrderDet> orderDets = new ArrayList<>();
        for (Order order : orders) {
            orderDets = orderService.orderdet(order.getOrdernum());  //获取订单详情
            order.setDetlist(orderDets);   //将订单详情放入对应的订单中
        }
        return orders;
    }

    @ApiOperation(value = "确认付款")
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 1, message = "操作成功"), @ApiResponse(code = 0, message = "操作失败"), @ApiResponse(code = 3, message = "权限不足")})
    @ApiImplicitParams({
    })
    public String update(String ordernum) {
        orderService.update(ordernum);
        return "付款成功";
    }

}
