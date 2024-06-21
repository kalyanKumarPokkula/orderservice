package com.bookstore.orderservice.controllers;


import com.bookstore.orderservice.models.Address;
import com.bookstore.orderservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/address")
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }
}
