package com.blog.blog.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EntradaBlog {
    private Integer idBlog;
    private String titleBlog;
    private String nameAuthor;
    private Date publicationDate;
}
