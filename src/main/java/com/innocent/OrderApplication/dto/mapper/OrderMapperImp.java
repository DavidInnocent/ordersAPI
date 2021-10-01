package com.innocent.OrderApplication.dto.mapper;

import com.innocent.OrderApplication.dto.model.OrderDto;
import com.innocent.OrderApplication.models.Order;

public class OrderMapperImp implements OrderMapper {

    @Override
    public OrderDto toDTO(Order order) {
        return new OrderDto().setCreated(order.getCreated())
                .setCustomerAddress(order.getCustomerAddress())
                .setCustomerName(order.getCustomerName())
                .setId(order.getId())
                .setOrderItems(order.getOrderItems());
    }
}
