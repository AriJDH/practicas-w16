package com.mercadolibre.bootcamp.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullLinkDto {
    private int id;
    private String url;
    private int redirectsCounter;
}
