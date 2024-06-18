package com.bookstore.orderservice.service;

import com.bookstore.orderservice.models.Order;
import com.bookstore.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long id){
        return orderRepository.findById(id);
    }


}
