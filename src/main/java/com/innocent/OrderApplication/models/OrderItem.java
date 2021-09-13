package com.innocent.OrderApplication.models;

import com.innocent.OrderApplication.utils.OrderLink;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "orderItems")
public class OrderItem implements Serializable {

    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long Id;

    @NonNull
    String Name;

    @NonNull
    Long Price;

    @OneToMany(mappedBy = "orderItem", cascade = CascadeType.ALL)
    private Set<OrderLink> orderItems = new HashSet<>();

}
