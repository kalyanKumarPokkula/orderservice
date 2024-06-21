package com.bookstore.orderservice.service;


import com.bookstore.orderservice.models.Order;
import com.bookstore.orderservice.models.OrderItem;
import com.bookstore.orderservice.repository.OrderItemRepository;
import com.bookstore.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public OrderItem createOrderItem(OrderItem orderItem , Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Double price = order.getTotalAmount();
        price += orderItem.getPrice();
        order.setTotalAmount(price);
        order.setUpdatedAt(LocalDateTime.now());
        orderRepository.save(order);

        orderItem.setOrder(order);

        return orderItemRepository.save(orderItem);

    }

    public List<OrderItem> createOrderItems(List<OrderItem> orderItems, Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Double price = order.getTotalAmount();;
        for(OrderItem item : orderItems){
            price += item.getPrice();

        }
        order.setTotalAmount(price);
        order.setUpdatedAt(LocalDateTime.now());
        orderRepository.save(order);

        for(OrderItem item : orderItems){
            item.setOrder(order);
        }



        return orderItemRepository.saveAll(orderItems);

    }
}
