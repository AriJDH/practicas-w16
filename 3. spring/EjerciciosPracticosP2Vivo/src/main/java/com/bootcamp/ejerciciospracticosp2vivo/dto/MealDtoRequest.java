package com.bootcamp.ejerciciospracticosp2vivo.dto;

import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MealDtoRequest {
    private String name;
    private Double weight;
}
