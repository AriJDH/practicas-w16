package com.mercadolibre.bootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntry {
    private int id;
    private String title;
    private String author;
    private LocalDate dateCreated=LocalDate.now();
}
