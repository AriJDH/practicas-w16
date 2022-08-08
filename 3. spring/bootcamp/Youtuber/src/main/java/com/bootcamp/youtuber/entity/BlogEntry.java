package com.bootcamp.youtuber.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogEntry {

    private String blogId;
    private String title;
    private String authorName;
    private Date publishDate;
}
