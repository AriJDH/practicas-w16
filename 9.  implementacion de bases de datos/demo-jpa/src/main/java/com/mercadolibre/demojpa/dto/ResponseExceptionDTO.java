package com.mercadolibre.demojpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ResponseExceptionDTO {
    public String title;
    public String message;
}
