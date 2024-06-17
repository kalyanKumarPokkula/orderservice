package com.bookstore.orderservice.models;

import com.bookstore.orderservice.enums.Status;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "order_id-seq")
    @SequenceGenerator(name = "order_id_seq" , sequenceName = "ORDER_ID_SEQ" , initialValue = 1)
    @Column( name = "order_id")
    private Long id;

    private Long userId;
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<OrderItem> items;


    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected  void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }


}
