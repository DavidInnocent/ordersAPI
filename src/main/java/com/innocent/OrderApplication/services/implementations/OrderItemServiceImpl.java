package com.innocent.OrderApplication.services.implementations;

import com.innocent.OrderApplication.dto.mapper.OrderItemMapper;
import com.innocent.OrderApplication.dto.model.OrderItemDto;
import com.innocent.OrderApplication.exceptions.OrderNotFoundException;
import com.innocent.OrderApplication.models.OrderItem;
import com.innocent.OrderApplication.repositories.OrderItemRepository;
import com.innocent.OrderApplication.repositories.OrderRepository;
import com.innocent.OrderApplication.services.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderRepository orderRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderItemDto> findAllOrderItems() {
        final List<OrderItem> all = orderItemRepository.findAll();
        List<OrderItemDto> collect = all.stream().map(OrderItemMapper::toDTO).collect(Collectors.toList());
//        collect.forEach(orderItemDto -> log.info("DATA {}",orderDto));
        return collect;
    }

    @Override
    public OrderItemDto findSingleOrderItem(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found with that id"));
        return OrderItemMapper.toDTO(orderItem);
    }

    @Override
    public OrderItemDto createSingleOrderItem(OrderItem orderItem) {
        return OrderItemMapper.toDTO(orderItemRepository.save(orderItem));
    }

    @Override
    public OrderItemDto updateOrderItem(OrderItem orderItem) {
        orderItemRepository.findById(orderItem.getId()).orElseThrow(()->new OrderNotFoundException("That order does not exist "));
        return OrderItemMapper.toDTO(orderItemRepository.save(orderItem));
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.findById(id).orElseThrow(()->new OrderNotFoundException("You can not delete an order that does not exist. "));
        orderItemRepository.deleteById(id);

    }

    @Override
    public void deleteAllOrderItems() {
        orderItemRepository.deleteAll();
    }
}
