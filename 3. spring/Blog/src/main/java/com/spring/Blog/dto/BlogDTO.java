package com.spring.Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BlogDTO {
    private int idBlog;
    private String title;
    private String authorName;
    private String date;
}
