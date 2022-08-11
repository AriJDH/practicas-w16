package com.grodriguez.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntryDTO {
    private int id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fecha;
}
