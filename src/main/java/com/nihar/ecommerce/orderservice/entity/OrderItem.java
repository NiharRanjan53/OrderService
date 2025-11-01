package com.nihar.ecommerce.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "orderItems")
public class OrderItem extends  BaseEntity{

    private Long productId;
    private int quantity;
    private Long pricePerUnit;
    private Long totalPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


}
