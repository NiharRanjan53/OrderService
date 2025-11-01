package com.nihar.ecommerce.orderservice.services;

import com.nihar.ecommerce.orderservice.dto.OrderRequestDTO;
import com.nihar.ecommerce.orderservice.dto.CreateOrderResponseDTO;

public interface IOrderService {
    CreateOrderResponseDTO createOrder(OrderRequestDTO requestDTO);
}
