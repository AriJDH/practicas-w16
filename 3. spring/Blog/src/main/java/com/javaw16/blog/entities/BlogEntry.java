package com.javaw16.blog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntry {
    private Integer id;
    private String title;
    private String author;
    private LocalDate postingDate;
}
