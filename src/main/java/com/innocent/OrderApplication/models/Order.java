package com.innocent.OrderApplication.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import java.util.Set;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="orders")
public class Order implements Serializable {

    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long Id;

    @JoinTable(
            name = "order_orderItem",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "orderItem_id")}
    )
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    Set<OrderItem> orderItems=new HashSet<>();

    @NonNull
    Date created=new Date();

    @NonNull
    String customerName,customerAddress;

}
