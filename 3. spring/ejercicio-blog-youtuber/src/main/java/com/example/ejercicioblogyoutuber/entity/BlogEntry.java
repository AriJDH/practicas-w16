package com.example.ejercicioblogyoutuber.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BlogEntry {

    private final Long id;
    private final String title, author;
    private final LocalDate publicationDate;

}
