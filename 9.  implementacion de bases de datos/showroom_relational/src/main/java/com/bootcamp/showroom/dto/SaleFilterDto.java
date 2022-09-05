package com.bootcamp.showroom.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class SaleFilterDto {
    private Long number;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private String paymentType;
}
