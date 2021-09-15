package com.innocent.OrderApplication.services.implementations;

import com.innocent.OrderApplication.dto.OrderDto;
import com.innocent.OrderApplication.dto.mapper.OrderMapper;
import com.innocent.OrderApplication.exceptions.OrderNotFoundException;
import com.innocent.OrderApplication.models.Order;
import com.innocent.OrderApplication.repositories.OrderRepository;
import com.innocent.OrderApplication.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDto> findAllOrders() {
        final List<Order> all = orderRepository.findAll();
        List<OrderDto> collect = all.stream().map(OrderMapper::toDTO).collect(Collectors.toList());
        collect.forEach(orderDto -> log.info("DATA {}",orderDto));
        return collect;
    }

    @Override
    public OrderDto findSingleOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found with that id"));
        return OrderMapper.toDTO(order);
    }

    @Override
    public OrderDto createSingleOrder(Order order) {
        return OrderMapper.toDTO(orderRepository.save(order));
    }

    @Override
    public OrderDto updateOrder(Order order) {
        orderRepository.findById(order.getId()).orElseThrow(()->new OrderNotFoundException("That order does not exist "));
        return OrderMapper.toDTO(orderRepository.save(order));
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("You can not delete an order that does not exist. "));
        orderRepository.deleteById(id);

    }

    @Override
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
