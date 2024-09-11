package com.bookstore.orderservice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "address_id_seq")
    @SequenceGenerator(name = "address_id_seq" , sequenceName = "ADDRESS_ID_SEQ" ,initialValue = 1,allocationSize = 1)
    @Column(name = "address_id")
    private Long id;

    @Column(unique = true)
    private Integer userId;
    
    private String email;

    @Column(name = "first_name" , nullable = false)
    private String firstName;
    @Column(name = "last_name" , nullable = false)
    private String lastName;

    @Column(name = "phone_number" , nullable = false)
    private String phoneNumber;


    @Column(name = "address_line1", nullable = false)
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

    @OneToMany(mappedBy = "shippingAddress" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Shipping> shippingAddress;

}
