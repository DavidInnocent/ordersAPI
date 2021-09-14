package com.innocent.OrderApplication.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import java.util.Set;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order implements Serializable {

    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long Id;

    @JoinTable(name = "order_orderItem",
    joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "orderItem_id")}
    )
    @ManyToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @NonNull
    Set<OrderItem> orderItems=new HashSet<>();

    @NonNull
    Date Created=new Date();

    @NonNull
    String CustomerName,CustomerAddress;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Date isCreated() {
        return Created;
    }

    public void setCreated(Date created) {
        Created = created;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public Order( @NonNull String customerName, @NonNull String customerAddress) {
        CustomerName = customerName;
        CustomerAddress = customerAddress;
    }
}
