package com.example.ejercicioyoutuber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntryDto {
    private int blogID;
    private String blogTitle;
    private String authorName;
    private LocalDate publishDate;
}
