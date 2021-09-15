package com.innocent.OrderApplication.controllers;

import com.innocent.OrderApplication.dto.OrderDto;
import com.innocent.OrderApplication.models.Order;
import com.innocent.OrderApplication.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(OrderController.URL)
public class OrderController {

    public static final String URL="/api/orders";
    private final OrderService orderService;

    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;

        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        log.info("Getting All Orders.............");

        List<OrderDto> orderList=orderService.findAllOrders();

        log.info("Finished Getting All Orders........");
        return new ResponseEntity<>(orderList,HttpStatus.OK);
    }
    @GetMapping("/getSingleOrder/{id}")
    public ResponseEntity<OrderDto> findOrder(@PathVariable Long id){
        log.info("Getting Single order.............");

            OrderDto order=orderService.findSingleOrder(id);
            log.info("Finished Getting order........");
            return new ResponseEntity<>(order,HttpStatus.OK);

    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDto> createOrder(@Validated @RequestBody Order order) {

        log.info("Creating single order.............");

        OrderDto orderSaved=orderService.createSingleOrder(order);

        log.info("Finished Creating order........");

        return new ResponseEntity<>(orderSaved, HttpStatus.CREATED);
    }

    @PutMapping("/updateOrder/{id}")
    public ResponseEntity<OrderDto> updateOrder(@Validated @RequestBody Order order) {

            log.info("Updating Single order.............");
            OrderDto orderUpdated=orderService.updateOrder(order);

            log.info("Finished Updating order........");
            return new ResponseEntity<>(orderUpdated,HttpStatus.OK);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable Long id) {

            log.info("Deleting Single order........");
            orderService.deleteOrder(id);
            log.info("Order deleted successfully.....");
            return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/deleteAllOrders")
    public ResponseEntity<?> deleteOrderById() {

            log.info("Deleting all order........");
            orderService.deleteAllOrders();
            log.info("Orders deleted successfully.....");
            return new ResponseEntity<>(HttpStatus.OK);

    }


}
