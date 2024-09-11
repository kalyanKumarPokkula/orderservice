package com.bookstore.orderservice.repository;

import com.bookstore.orderservice.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment , Long> {


}
