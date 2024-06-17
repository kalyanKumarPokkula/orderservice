package com.bookstore.orderservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "order_id-seq")
    @SequenceGenerator(name = "order_id_seq" , sequenceName = "ORDER_ID_SEQ" , initialValue = 1)
    @Column( name = "order_id")
    private Long id;

    private Long userId;
    private Double totalAmount;
    private String status;
    private Date createdAt;


    @PrePersist
    protected void onCreate(){
        createdAt = new Date();
    }


}
