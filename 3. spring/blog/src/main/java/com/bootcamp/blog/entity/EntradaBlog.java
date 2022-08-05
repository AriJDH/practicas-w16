package com.bootcamp.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class EntradaBlog {
    private int id;
    private String title;
    private String authorName;
    private LocalDate publishDate;
}
