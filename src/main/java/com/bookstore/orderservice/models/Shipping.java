package com.bookstore.orderservice.models;


import com.bookstore.orderservice.enums.ShippingMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "Shipping_id_seq")
    @SequenceGenerator(name = "shipping_id_seq" , sequenceName = "SHIPPING_ID_SEQ" , initialValue = 1)
    @Column(name = "shipping_id")
    private Long id;

    private Long orderId;
    private Date shippingDate;
    private ShippingMethod ShippingMethod;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address shippingAddress;
    

}
