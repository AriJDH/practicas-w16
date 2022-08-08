package com.spring.Blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    private int idBlog;
    private String title;
    private String authorName;
    private String date;

}
