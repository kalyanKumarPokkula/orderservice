package com.bookstore.orderservice.models;


import com.bookstore.orderservice.enums.ShippingMethod;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shippings")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "Shipping_id_seq")
    @SequenceGenerator(name = "shipping_id_seq" , sequenceName = "SHIPPING_ID_SEQ" , initialValue = 1)
    @Column(name = "shipping_id")
    private Long id;

    private LocalDate shippingDate;

    private LocalDate deliveryDate;

    @Enumerated(EnumType.STRING)
    private ShippingMethod ShippingMethod;

    @OneToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference(value = "order-shipping")
    private Order orderShipping;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonBackReference
    private Address shippingAddress;
    

}
