package com.youtuber.blog.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Integer idBlog;
    private String titleBlog;
    private String nameBlog;
    private Date datePublishBlog;
}
