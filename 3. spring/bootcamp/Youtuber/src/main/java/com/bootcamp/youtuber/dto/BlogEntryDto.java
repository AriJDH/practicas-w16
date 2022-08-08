package com.bootcamp.youtuber.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogEntryDto {

    private String blogId;
    private String title;
    private String authorName;
    private Date publishDate;
}
