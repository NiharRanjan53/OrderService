package com.nihar.ecommerce.orderservice.clients;

import com.nihar.ecommerce.orderservice.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ProductServiceClient {

    private final RestTemplate restTemplate;

    public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public ProductDTO getProductById(Long productId) {
        String url = "http://localhost:3000/api/products/" + productId;
        ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
        return response.getBody();
    }

}
