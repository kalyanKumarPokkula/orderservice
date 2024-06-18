package com.bookstore.orderservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "address_id_seq")
    @SequenceGenerator(name = "address_id_seq" , sequenceName = "ADDRESS_ID_SEQ" ,initialValue = 1)
    @Column(name = "address_id")
    private Long id;

    private Integer userId;

    @Column(name = "first_name" , nullable = false)
    private String firstName;
    @Column(name = "last_name" , nullable = false)
    private String lastName;

    @Column(name = "phone_number" , nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String addressLine1;

    private String addressLine2;

    @Column(name = "city" , nullable = false)
    private String city;

    @Column(name = "state" , nullable = false)
    private String state;

    @Column(name = "country" , nullable = false)
    private String country;

    @Column(name = "postal_code" , nullable = false)
    private String postalCode;

    @OneToOne(mappedBy = "shippingAddress" , cascade = CascadeType.ALL)
    private Shipping shipping;

}
