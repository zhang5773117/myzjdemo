package com.zb.service.impl;

import com.zb.entity.Order;
import com.zb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public List<Order> currentUserOrderInfo(Integer uid) {
        String url = "http://localhost:8001/findOrderByUid/" + uid;
        //http请求调用远程方法
        List<Order> list = restTemplate.getForObject(url, List.class);
        return list;
    }

    @Override
    public int currentUserAddOrder(Order order) {
        System.out.println("consumer---->currentUserAddOrder");
        List<ServiceInstance> instances = discoveryClient.getInstances("order-server-provider");
        ServiceInstance serviceInstance = instances.get(0);
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/saveOrder";
        System.out.println(url);
        ResponseEntity<Integer> integerResponseEntity = restTemplate.postForEntity(url, order, Integer.class);
        return integerResponseEntity.getBody();
    }
}
