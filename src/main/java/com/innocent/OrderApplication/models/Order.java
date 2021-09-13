package com.innocent.OrderApplication.models;

import com.innocent.OrderApplication.utils.OrderLink;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Entity
@Data
@Table(name = "orders")
public class Order implements Serializable {

    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long Id;

    Date Created;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderLink> ordersUtil;

    @NonNull
    String CustomerName,CustomerAddress;

    @OneToMany(cascade = CascadeType.PERSIST)
    @NonNull List<OrderItem> orderedItems;


    public Order(String name, OrderLink... orders) {

//        for(OrderLink orderLink : orders) ordersUtil.s(this);
        this.ordersUtil = Stream.of(orders).collect(Collectors.toSet());
    }


}
