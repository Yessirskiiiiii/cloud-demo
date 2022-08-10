package com.threewater.order.service;

import com.threewater.order.entity.User;
import com.threewater.order.mapper.OrderMapper;
import com.threewater.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1. 查询订单
        Order order = orderMapper.findById(orderId);
        // 2. 利用 restTemplate 发起 http 请求，查询用户
        // 2.1 url 路径
        String url = "http://localhost:8081/user/" + order.getUserId();
        // 2.2 发送 http 请求，实现远程调用
        User user = restTemplate.getForObject(url, User.class);
        // 3. 封装 user 到 Order
        order.setUser(user);
        // 4. 返回
        return order;
    }
}
