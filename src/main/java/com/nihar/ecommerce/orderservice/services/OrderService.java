package com.nihar.ecommerce.orderservice.services;

import com.nihar.ecommerce.orderservice.clients.ProductServiceClient;
import com.nihar.ecommerce.orderservice.dto.OrderItemDTO;
import com.nihar.ecommerce.orderservice.dto.OrderRequestDTO;
import com.nihar.ecommerce.orderservice.dto.CreateOrderResponseDTO;
import com.nihar.ecommerce.orderservice.dto.ProductDTO;
import com.nihar.ecommerce.orderservice.entity.Order;
import com.nihar.ecommerce.orderservice.entity.OrderItem;
import com.nihar.ecommerce.orderservice.mappers.OrderItemMapper;
import com.nihar.ecommerce.orderservice.mappers.OrderMapper;
import com.nihar.ecommerce.orderservice.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService{
    private final OrderRepository orderRepository;
    private final ProductServiceClient productClient;
    public OrderService(OrderRepository orderRepository, ProductServiceClient productClient){
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO requestDTO) {
        Order order = OrderMapper.toEntity(requestDTO);

        List<OrderItem> items = new ArrayList<>();

        for(OrderItemDTO itemDTO : requestDTO.getItems()){
            ProductDTO productDTO = productClient.getProductById(itemDTO.getProductId());
            double pricePerUnit = productDTO.getPrice();
            double totalPrice = pricePerUnit * itemDTO.getQuantity();

            OrderItem item = OrderItemMapper.toEntity(
                    itemDTO,
                    order,
                    pricePerUnit,
                    totalPrice
            );

            items.add(item);
        }

        order.setItems(items);
        Order createdOrder = orderRepository.save(order);

        return OrderMapper.toCreateOrderResponseDTO(createdOrder);
    }
}
