package com.youtuber.blog.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private Integer idBlog;
    private String titleBlog;
    private String nameBlog;
    private Date datePublishBlog;
}
