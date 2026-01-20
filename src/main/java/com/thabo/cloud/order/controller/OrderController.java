package com.thabo.cloud.order.controller;

import com.thabo.cloud.order.dto.OrderDTOFrontEnd;
import com.thabo.cloud.order.dto.OrderRequest;
import com.thabo.cloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderRequest> saveOrder(@RequestBody OrderDTOFrontEnd orderDetails) {
        OrderRequest orderSavedInDb = orderService.saveOrderInDb(orderDetails);
        return new ResponseEntity<>(orderSavedInDb, HttpStatus.CREATED);
    }
}
