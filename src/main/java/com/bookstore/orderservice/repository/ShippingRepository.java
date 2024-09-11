package com.bookstore.orderservice.repository;

import com.bookstore.orderservice.models.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping , Long> {


}
