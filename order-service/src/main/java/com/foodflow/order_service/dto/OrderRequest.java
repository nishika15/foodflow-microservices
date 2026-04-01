package com.foodflow.order_service.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private Long userId;
    private Long restaurantId;
    private String items;
    private Double totalAmount;
    private String deliveryAddress;
}