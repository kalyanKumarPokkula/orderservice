package com.bookstore.orderservice.models;

import com.bookstore.orderservice.enums.Status;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "order_id_seq")
    @SequenceGenerator(name = "order_id_seq" , sequenceName = "ORDER_ID_SEQ" , initialValue = 1)
    @Column( name = "order_id")
    private Long id;

    private Integer userId;
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonManagedReference(value = "order-orderItem")
    private List<OrderItem> items;

    @OneToOne(mappedBy = "orderShipping" , cascade = CascadeType.ALL)
    @JsonManagedReference(value = "order-shipping")
    private Shipping shipping;


    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.status = Status.PENDING;
    }


    @PreUpdate
    protected  void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }


}
