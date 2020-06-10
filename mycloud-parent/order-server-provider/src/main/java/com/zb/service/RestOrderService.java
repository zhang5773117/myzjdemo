package com.zb.service;

import com.zb.entity.Order;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestOrderService {
    private static List<Order> orders = new ArrayList<>();

    static {
        orders.add(new Order(1, "订单1", 20.0, 1));
        orders.add(new Order(2, "订单2", 20.0, 2));
        orders.add(new Order(3, "订单3", 20.0, 1));
        orders.add(new Order(4, "订单4", 20.0, 2));
        orders.add(new Order(5, "订单5", 20.0, 1));
    }

    @GetMapping(value = "/findOrderByUid/{uid}")
    public List<Order> findOrderByUid(@PathVariable("uid") Integer uid) {
        List<Order> list = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUid().equals(uid)) {
                list.add(order);
            }
        }
        return list;
    }

    @PostMapping(value = "/saveOrder")
    public int saveOrder(@RequestBody Order order) {
        System.out.println("provider的添加方法执行"+order.toString());
        orders.add(order);
        return 1;
    }

}
