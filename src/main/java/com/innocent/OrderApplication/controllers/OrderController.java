package com.innocent.OrderApplication.controllers;

import com.innocent.OrderApplication.exceptions.OrderNotFoundException;
import com.innocent.OrderApplication.models.Order;
import com.innocent.OrderApplication.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(OrderController.URL)
public class OrderController {

    public static final String URL="/api/orders";
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders(){
        log.info("Getting All Orders.............");

        List<Order> orderList=orderService.findAllOrders();

        log.info("Finished Getting All Orders........");
        return new ResponseEntity<>(orderList,HttpStatus.OK);
    }
    @GetMapping("/getSingleOrder/{id}")
    public ResponseEntity<Order> findOrder(@PathVariable Long id) throws OrderNotFoundException{
        log.info("Getting Single order.............");
        try{
            Order order=orderService.findSingleOrder(id);
            log.info("Finished Getting order........");
            return new ResponseEntity<>(order,HttpStatus.OK);
        }
        catch(OrderNotFoundException e)
        {
            throw new OrderNotFoundException("The order with that ID was not found");

        }

    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@Validated @RequestBody Order order) {

        log.info("Creating single order.............");

        Order orderSaved=orderService.createSingleOrder(order);

        log.info("Finished Creating order........");

        return new ResponseEntity<>(orderSaved, HttpStatus.CREATED);
    }

    @PutMapping("/updateOrder/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id,@Validated @RequestBody Order order) throws OrderNotFoundException {

        try {
            log.info("Updating Single order.............");


            Order orderInDb=orderService.findSingleOrder(id);
            Order orderUpdated=orderService.updateOrder(order);
            log.info("Finished Updating order........");
            return new ResponseEntity<>(orderUpdated,HttpStatus.OK);
        }
        catch (OrderNotFoundException userNotFoundException)
        {
            log.info("Finished getting order........");
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"The order was not found.");
        }
    }

    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<Order> deleteOrderById(@PathVariable Long id) throws OrderNotFoundException {
        try{
            log.info("Deleting Single order........");
            Order order=orderService.findSingleOrder(id);
            orderService.deleteOrder(order);
            log.info("Order deleted successfully.....");
            return new ResponseEntity<>(order,HttpStatus.OK);


        }
        catch (OrderNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found",exception);
        }

    }


}
