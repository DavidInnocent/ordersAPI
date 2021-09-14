package com.innocent.OrderApplication.models;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name="order_items")
public class OrderItem implements Serializable {

    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long Id;

    @NonNull
    String Name;

    @NonNull
    Long Price;


    public OrderItem(@NonNull String name, @NonNull Long price) {
        Name = name;
        Price = price;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

}
