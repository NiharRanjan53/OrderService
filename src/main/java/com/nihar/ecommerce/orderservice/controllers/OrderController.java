package com.nihar.ecommerce.orderservice.controllers;

import com.nihar.ecommerce.orderservice.dto.CreateOrderResponseDTO;
import com.nihar.ecommerce.orderservice.dto.OrderRequestDTO;
import com.nihar.ecommerce.orderservice.services.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request){

        return ResponseEntity.ok(orderService.createOrder(request));

    }
}
