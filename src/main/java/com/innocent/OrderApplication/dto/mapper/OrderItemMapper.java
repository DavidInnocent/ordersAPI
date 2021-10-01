package com.innocent.OrderApplication.dto.mapper;


import com.innocent.OrderApplication.dto.model.OrderItemDto;
import com.innocent.OrderApplication.models.OrderItem;

public class OrderItemMapper {
    public static OrderItemDto toDTO(OrderItem orderItem){
        return new OrderItemDto()
                .setId(orderItem.getId())
                .setName(orderItem.getName())
                .setPrice(orderItem.getPrice());
    }

}
