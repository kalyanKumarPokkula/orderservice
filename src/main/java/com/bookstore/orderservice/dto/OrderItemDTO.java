package com.bookstore.orderservice.dto;

import com.bookstore.orderservice.Book;
import com.bookstore.orderservice.models.OrderItem;



public class OrderItemDTO {
    private OrderItem orderItem;
    private Book book;

    public OrderItemDTO(OrderItem orderItem , Book book){
        this.book = book;
        this.orderItem = orderItem;
    }
}
