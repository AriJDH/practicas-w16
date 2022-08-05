package com.example.ejercicioblogyoutuber.dto;

import com.example.ejercicioblogyoutuber.entity.BlogEntry;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BlogEntryDTO {

    private final Long id;
    private final String title, author;
    private final LocalDate publicationDate;
    public BlogEntryDTO(BlogEntry aBlog) {
        id = aBlog.getId();
        title = aBlog.getTitle();
        author = aBlog.getAuthor();
        publicationDate = aBlog.getPublicationDate();
    }
}
