package com.bootcamp.blog.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {
    private Integer id;
    private String title;
    private String nameAuthor;
    private Date publicationDate;
}
