package com.bootcamp.entradasblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private int id;
    private String title;
    private String author;
    private String date;
}
