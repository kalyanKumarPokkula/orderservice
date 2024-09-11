package com.bookstore.orderservice.controllers;


import com.bookstore.orderservice.Book;
import com.bookstore.orderservice.dto.OrderItemDTO;
import com.bookstore.orderservice.models.OrderItem;
import com.bookstore.orderservice.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;


    @PostMapping("/orderItem")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem , @RequestParam Long orderId){
        System.out.println(orderItem);
        return orderItemService.createOrderItem(orderItem , orderId);
    }

    @GetMapping(value = "/orderItem/{id}",produces = "application/json")
    public ResponseEntity<Book> getOrderItem(@PathVariable Long id){
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderItemService.getOrderItem(id));
    }

    @PostMapping("/orderItems")
    public List<OrderItem> createOrderItems(@RequestBody List<OrderItem> orderItems , @RequestParam Long orderId){
        return orderItemService.createOrderItems(orderItems,orderId);
    }
}
