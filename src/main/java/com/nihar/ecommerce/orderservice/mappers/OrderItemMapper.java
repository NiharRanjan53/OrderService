package com.nihar.ecommerce.orderservice.mappers;

import com.nihar.ecommerce.orderservice.dto.OrderItemDTO;
import com.nihar.ecommerce.orderservice.entity.Order;
import com.nihar.ecommerce.orderservice.entity.OrderItem;

public class OrderItemMapper {
    public static OrderItem toEntity(OrderItemDTO itemDto, Order order, double pricePerUnit, double totalPrice){
        return OrderItem.builder()
                .productId(itemDto.getProductId())
                .quantity(itemDto.getQuantity())
                .pricePerUnit(pricePerUnit)
                .totalPrice(totalPrice)
                .order(order)
                .build();
    }


}
