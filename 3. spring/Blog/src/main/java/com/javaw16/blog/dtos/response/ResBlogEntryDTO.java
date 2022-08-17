package com.javaw16.blog.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResBlogEntryDTO {
    private Integer id;
    private String title;
    private String author;
    private LocalDate postingDate;
}
