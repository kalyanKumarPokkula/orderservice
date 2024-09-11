package com.bookstore.orderservice.repository;

import com.bookstore.orderservice.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address ,Long> {
    Address findByUserId(Integer userId);
}
