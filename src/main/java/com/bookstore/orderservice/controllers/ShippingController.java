package com.bookstore.orderservice.controllers;


import com.bookstore.orderservice.models.Shipping;
import com.bookstore.orderservice.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping("/shipping")
    public Shipping createShipping(@RequestBody Shipping shipping , @RequestParam Long orderId , @RequestParam Long addressId){
        return shippingService.createShipping(shipping,orderId,addressId);
    }
}
