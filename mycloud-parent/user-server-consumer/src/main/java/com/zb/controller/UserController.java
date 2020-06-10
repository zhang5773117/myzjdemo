package com.zb.controller;

import com.zb.entity.Order;
import com.zb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController  {

    @Autowired
    private UserService userService ;

    @GetMapping(value = "/show")
    public List<Order> show(Integer uid){
        return userService.currentUserOrderInfo(uid);
    }

    @PostMapping(value = "/add")
    public int add(Order order){
        return userService.currentUserAddOrder(order);
    }


}
