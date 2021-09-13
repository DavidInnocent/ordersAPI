package com.innocent.OrderApplication.repositories;

import com.innocent.OrderApplication.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
