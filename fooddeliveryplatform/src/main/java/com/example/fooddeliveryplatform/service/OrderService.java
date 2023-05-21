package com.example.fooddeliveryplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryplatform.dao.OrderRepository;
import com.example.fooddeliveryplatform.model.Orders;


@Service
public class OrderService {
    
    @Autowired
    OrderRepository orderRepository;

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public Orders createOrder(Orders order) {
        return orderRepository.save(order);
    }

    public Orders updateOrder(Long orderId, Orders order) {
        Orders existingOrder = orderRepository.findById(orderId).orElse(null);
        if (existingOrder != null) {
            existingOrder.setFoodItem(order.getFoodItem());
            existingOrder.setUser(order.getUser());
            // Set other properties as needed
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    public boolean deleteOrder(Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }
}
