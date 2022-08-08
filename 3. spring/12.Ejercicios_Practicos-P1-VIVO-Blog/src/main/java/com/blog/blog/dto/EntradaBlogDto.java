package com.blog.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EntradaBlogDto {
    private Integer idBlog;
    private String titleBlog;
    private String nameAuthor;
    private Date publicationDate;
}
