package com.innocent.OrderApplication.dto.mapper;

import com.innocent.OrderApplication.dto.model.OrderDto;
import com.innocent.OrderApplication.models.Order;

public interface OrderMapper {
    OrderDto toDTO(Order order);

}
