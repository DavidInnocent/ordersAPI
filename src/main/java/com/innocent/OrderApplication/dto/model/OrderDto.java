package com.innocent.OrderApplication.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.innocent.OrderApplication.models.OrderItem;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Accessors(chain = true)
@Data
public class OrderDto {

    Long Id;

    Set<OrderItem> orderItems=new HashSet<>();

    Date Created;

    String customerName,customerAddress;
}
