package com.bootcamp.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntry {

    private String Title;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate postDate;

}
