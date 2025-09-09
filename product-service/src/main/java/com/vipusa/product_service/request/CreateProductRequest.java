package com.vipusa.product_service.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {

    private String productName;

    private Integer stock;

    private Double price;

    private String description;
}
