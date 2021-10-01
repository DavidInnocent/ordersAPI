package com.innocent.OrderApplication.repositories;

import com.innocent.OrderApplication.models.Order;
import com.innocent.OrderApplication.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
