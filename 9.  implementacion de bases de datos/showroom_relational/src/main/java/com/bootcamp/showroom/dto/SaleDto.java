package com.bootcamp.showroom.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class SaleDto {
    private Long number;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private Double total;
    private String paymentType;
    @JsonIgnoreProperties("sale")
    private List<ClothesDto> clothes;
}
