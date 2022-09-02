package com.example.practicahql.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {

    private Long id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String name;
    private int ranking;
    private boolean active;
}
