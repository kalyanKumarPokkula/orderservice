package com.bookstore.orderservice.service;


import com.bookstore.orderservice.models.Address;
import com.bookstore.orderservice.models.Order;
import com.bookstore.orderservice.models.Payment;
import com.bookstore.orderservice.repository.OrderRepository;
import com.bookstore.orderservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Payment createPayment(Payment payment , Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        payment.setOrderPayment(order);

        return paymentRepository.save(payment);
    }
}
