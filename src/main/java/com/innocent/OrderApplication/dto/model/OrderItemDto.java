package com.innocent.OrderApplication.dto.model;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderItemDto {

    Long Id;

    String Name;

    Long Price;
}
