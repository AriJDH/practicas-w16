package com.bootcamp.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostFechaDTO {
    private int day;
    private int month;
    private int year;
}
