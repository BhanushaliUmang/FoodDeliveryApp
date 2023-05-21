package com.example.fooddeliveryplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddeliveryplatform.model.Orders;
import com.example.fooddeliveryplatform.service.OrderService;

import jakarta.persistence.criteria.Order;

@RestController
@RequestMapping("/Order")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @GetMapping("/getAll")
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("getById/{orderId}")
    public Orders getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping("/addOrder")
    public Orders createOrder(@RequestBody Orders order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/update/{orderId}")
    public Orders updateOrder(@PathVariable Long orderId, @RequestBody Orders order) {
        return orderService.updateOrder(orderId, order);
    }

    @DeleteMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
