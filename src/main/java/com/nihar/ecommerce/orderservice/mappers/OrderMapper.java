package com.nihar.ecommerce.orderservice.mappers;

import com.nihar.ecommerce.orderservice.dto.CreateOrderResponseDTO;
import com.nihar.ecommerce.orderservice.dto.OrderRequestDTO;
import com.nihar.ecommerce.orderservice.entity.Order;
import com.nihar.ecommerce.orderservice.enums.OrderStatus;


public class OrderMapper {

    public static Order toEntity(OrderRequestDTO dto){
        return Order.builder()
                .userId(dto.getUserId())
                .status(OrderStatus.PENDING)
                .build();

    }
    public static CreateOrderResponseDTO toCreateOrderResponseDTO(Order order){
        return CreateOrderResponseDTO.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .build();
    }



}
