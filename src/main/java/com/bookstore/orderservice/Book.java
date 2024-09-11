package com.bookstore.orderservice;

import lombok.Data;

@Data
public class Book {
    private Long book_id;
    private String title;
    private Double price;
    private String posterurl;

}
