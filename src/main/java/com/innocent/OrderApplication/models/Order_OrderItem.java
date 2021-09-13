package com.innocent.OrderApplication.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "order_orderItems")
public class Order_OrderItem implements Serializable {

    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long Id;
    Long OrderItemId,OrderId;


}
