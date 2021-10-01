package com.innocent.OrderApplication.services;

import com.innocent.OrderApplication.dto.model.OrderDto;
import com.innocent.OrderApplication.models.Order;

import java.util.List;

public interface OrderService {

    List<OrderDto> findAllOrders();
    OrderDto findSingleOrder(Long id);
    OrderDto createSingleOrder(Order order);
    OrderDto updateOrder(Order order);
    void deleteOrder(Long id);
    void deleteAllOrders();
}
