package com.innocent.OrderApplication.repositories;

import com.innocent.OrderApplication.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByCustomerName(String customerName);
}
