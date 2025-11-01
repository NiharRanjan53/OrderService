package com.nihar.ecommerce.orderservice.repository;

import com.nihar.ecommerce.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
