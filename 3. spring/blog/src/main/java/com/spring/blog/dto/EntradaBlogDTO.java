package com.spring.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDTO {

    private Integer id;
    private String title;
    private String author;
    private LocalDate publishDate;

}
