package com.bootcamp.linktracer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Link {
    private int id;
    private String url;
    private String password;
    private int numRedirects;
    private boolean isActive;
}
