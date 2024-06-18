package com.bookstore.orderservice.repository;

import com.bookstore.orderservice.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address ,Long> {
}
