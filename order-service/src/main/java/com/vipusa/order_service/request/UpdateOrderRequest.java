package com.vipusa.order_service.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateOrderRequest {
    private String customerName;
    private String productName;
    private Integer quantity;
    private Double totalPrice;
}