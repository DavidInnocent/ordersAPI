package com.innocent.OrderApplication.dto.mapper;

import com.innocent.OrderApplication.dto.OrderDto;
import com.innocent.OrderApplication.models.Order;
import org.aspectj.weaver.ast.Or;

public class OrderMapper {
    public static OrderDto toDTO(Order order){
        return new OrderDto().setCreated(order.getCreated())
                .setCustomerAddress(order.getCustomerAddress())
                .setCustomerName(order.getCustomerName())
                .setId(order.getId())
                .setOrderItems(order.getOrderItems());
    }

}
