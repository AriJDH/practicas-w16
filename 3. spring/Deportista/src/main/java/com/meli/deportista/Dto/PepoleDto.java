package com.meli.deportista.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PepoleDto {
    private String name;
    private String last_name;
    private Integer age;
}
