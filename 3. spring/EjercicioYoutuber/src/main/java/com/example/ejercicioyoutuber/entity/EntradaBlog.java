package com.example.ejercicioyoutuber.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private int blogID;
    private String blogTitle;
    private String authorName;
    private LocalDate publishDate;
}
