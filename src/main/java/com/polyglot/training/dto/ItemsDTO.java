package com.polyglot.training.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemsDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer stock;
    private Long price;
}
