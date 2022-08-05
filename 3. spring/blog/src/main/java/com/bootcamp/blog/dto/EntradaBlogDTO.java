package com.bootcamp.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class EntradaBlogDTO {
    private int id;
    private String title;
    private String authorName;
    private LocalDate publishDate;
}
