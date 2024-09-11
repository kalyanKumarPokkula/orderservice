package com.bookstore.orderservice.models;

import com.bookstore.orderservice.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id_seq")
    @SequenceGenerator(name = "payment_id_seq", sequenceName = "PAYMENT_ID_SEQ",initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String stripePaymentId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentMethod = PaymentStatus.CARD;

    @OneToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference(value = "order-payment")
    private Order orderPayment;

    private LocalDateTime paymentDate;
    private Double amount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    @PrePersist
    protected void onCreate(){
        this.paymentDate = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();

    }

    @PreUpdate
    protected  void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }




}
