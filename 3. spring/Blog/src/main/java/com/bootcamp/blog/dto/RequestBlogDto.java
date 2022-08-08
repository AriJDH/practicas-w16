package com.bootcamp.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestBlogDto {
    private Integer idBlog;
    private String title;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate postDate;
}
