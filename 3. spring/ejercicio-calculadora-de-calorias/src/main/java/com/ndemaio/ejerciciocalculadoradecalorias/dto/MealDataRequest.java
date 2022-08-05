package com.ndemaio.ejerciciocalculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@AllArgsConstructor
public class MealDataRequest {

    private final String name;
    private final Float weight;

}
