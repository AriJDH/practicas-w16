package com.bootcamp.showroom.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ClothesDto {
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer amount;
    private Double sellPrice;
    @JsonIgnoreProperties("clothes")
    private SaleDto sale;
}
