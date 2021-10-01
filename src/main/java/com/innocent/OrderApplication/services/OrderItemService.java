package com.innocent.OrderApplication.services;

import com.innocent.OrderApplication.dto.model.OrderItemDto;
import com.innocent.OrderApplication.models.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItemDto> findAllOrderItems();
    OrderItemDto findSingleOrderItem(Long id);
    OrderItemDto createSingleOrderItem(OrderItem orderItem);
    OrderItemDto updateOrderItem(OrderItem orderitem);
    void deleteOrderItem(Long id);
    void deleteAllOrderItems();
}
