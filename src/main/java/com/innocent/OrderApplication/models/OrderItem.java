package com.innocent.OrderApplication.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="order_items")
public class OrderItem implements Serializable {

    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long Id;

    @NonNull
    String Name;

    @NonNull
    Long Price;

}
