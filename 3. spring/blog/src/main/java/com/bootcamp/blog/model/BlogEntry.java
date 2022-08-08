package com.bootcamp.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntry {
    private String id;
    private String title;
    private String author;
    private String pubDate;
}
