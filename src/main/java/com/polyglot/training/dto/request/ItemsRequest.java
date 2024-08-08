package com.polyglot.training.dto.request;

import lombok.Data;

@Data
public class ItemsRequest {
    private String name;
    private String description;
    private Integer stock;
    private Long price;
}
