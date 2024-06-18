package com.bookstore.orderservice.repository;

import com.bookstore.orderservice.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
