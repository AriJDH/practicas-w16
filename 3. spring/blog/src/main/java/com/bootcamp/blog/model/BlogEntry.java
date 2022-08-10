package com.bootcamp.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntry {
    private int blogId;
    private String blogTitle;
    private String authorName;
    private LocalDate publicationDate;
}
