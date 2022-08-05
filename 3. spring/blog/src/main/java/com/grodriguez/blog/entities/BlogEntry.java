package com.grodriguez.blog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntry {
    private int id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fecha;
}
