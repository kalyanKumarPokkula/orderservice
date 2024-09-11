package com.bookstore.orderservice.controllers;


import com.bookstore.orderservice.models.Payment;
import com.bookstore.orderservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment , @RequestParam Long orderId){
        System.out.println(payment.toString());
        System.out.println(orderId);
        return paymentService.createPayment(payment, orderId);
    }
}
