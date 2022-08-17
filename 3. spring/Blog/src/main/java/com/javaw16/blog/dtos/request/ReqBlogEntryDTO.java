package com.javaw16.blog.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqBlogEntryDTO {
    private Integer id;
    private String title;
    private String author;
}
