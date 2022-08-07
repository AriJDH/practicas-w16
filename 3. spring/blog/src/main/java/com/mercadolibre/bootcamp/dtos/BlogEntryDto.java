package com.mercadolibre.bootcamp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntryDto {
    private String title;
    private String author;
    private LocalDate dateCreated;
}
