package com.innocent.OrderApplication.services;

import com.innocent.OrderApplication.models.Order;
import com.innocent.OrderApplication.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrders();
    Order findSingleOrder(Long id);
    Order createSingleOrder(Order order);
    Order updateOrder(Order order);
    Order deleteOrder(Order order);

}
