package com.bootcamp.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private Long id;
    private String link;
    private String password;
    private Long views;
}
