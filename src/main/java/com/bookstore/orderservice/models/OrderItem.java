package com.bookstore.orderservice.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "order_item_id_seq")
    @SequenceGenerator(name = "order_item_id_seq" , sequenceName = "ORDER_ITEM_ID_SEQ" , initialValue = 1,allocationSize = 1)
    @Column(name = "order_item_id")
    private Long id;

    private Integer bookId;
    private Integer quantity;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "order_id" )
    @JsonBackReference(value = "order-orderItem")
    private Order order;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }


}
