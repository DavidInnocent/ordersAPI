package com.innocent.OrderApplication.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String order_not_found) {
        super(order_not_found);
    }
}
