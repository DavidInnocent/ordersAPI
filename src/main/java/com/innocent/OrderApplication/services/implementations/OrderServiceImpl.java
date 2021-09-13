package com.innocent.OrderApplication.services.implementations;

import com.innocent.OrderApplication.models.Order;
import com.innocent.OrderApplication.repositories.OrderRepository;
import com.innocent.OrderApplication.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findSingleOrder(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public Order createSingleOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order deleteOrder(Order order) {
        orderRepository.delete(order);
        return order;
    }
}
