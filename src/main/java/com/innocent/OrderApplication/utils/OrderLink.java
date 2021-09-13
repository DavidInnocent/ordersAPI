package com.innocent.OrderApplication.utils;

import com.innocent.OrderApplication.models.Order;
import com.innocent.OrderApplication.models.OrderItem;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.Flow;

@Data
@Entity
public class OrderLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderItem_id")
    private OrderItem orderItem;


    public OrderLink(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderLink)) return false;
        OrderLink that = (OrderLink) o;
        return Objects.equals(order.getCustomerName(), that.order.getCustomerName()) &&
                Objects.equals(orderItem.getName(), that.orderItem.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(order.getCustomerName(), orderItem.getName());
    }
}