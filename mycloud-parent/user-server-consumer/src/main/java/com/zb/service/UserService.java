package com.zb.service;

import com.zb.entity.Order;

import java.util.List;

public interface UserService {
    public List<Order> currentUserOrderInfo(Integer uid);

    public int currentUserAddOrder(Order order);
}
