package com.vipusa.product_service.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateProductRequest {

    private String productName;

    private String description;

    private Double price;
}
