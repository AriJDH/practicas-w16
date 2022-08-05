package com.spring.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {

    private Integer id;
    private String title;
    private String author;
    private LocalDate publishDate;

}
