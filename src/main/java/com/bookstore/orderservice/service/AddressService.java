package com.bookstore.orderservice.service;



import com.bookstore.orderservice.models.Address;
import com.bookstore.orderservice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Address address){
        System.out.println(address.toString());
        if (address.getAddressLine1() == null) {
            throw new IllegalArgumentException("Address Line 1 cannot be null");
        }
        return addressRepository.save(address);
    }

    public Optional<Address> getAddress(Long id){
        return addressRepository.findById(id);
    }
    public Optional<Address> getAddressByUserId(Integer id){
        return Optional.ofNullable(addressRepository.findByUserId(id));
    }
}
