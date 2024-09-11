package com.bookstore.orderservice.controllers;


import com.bookstore.orderservice.models.Address;
import com.bookstore.orderservice.models.Order;
import com.bookstore.orderservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/address")
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Optional<Address>> getAddressById(@PathVariable Long id){
        Optional<Address> order = addressService.getAddress(id);
        return ResponseEntity.ok(order);

    }

    @GetMapping("/address/user/{id}")
    public ResponseEntity<Optional<Address>> getAddressByUserId(@PathVariable Integer id){
        Optional<Address> order = addressService.getAddressByUserId(id);
        return ResponseEntity.ok(order);

    }
}
