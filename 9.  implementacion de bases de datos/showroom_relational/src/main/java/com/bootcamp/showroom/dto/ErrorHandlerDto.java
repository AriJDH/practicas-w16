package com.bootcamp.showroom.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorHandlerDto {
    private Integer error;
    private String message;
}
