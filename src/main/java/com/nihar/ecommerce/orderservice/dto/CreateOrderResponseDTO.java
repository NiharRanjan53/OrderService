package com.nihar.ecommerce.orderservice.dto;

import com.nihar.ecommerce.orderservice.enums.OrderStatus;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponseDTO {
    private Long orderId;
    private OrderStatus status;
}
