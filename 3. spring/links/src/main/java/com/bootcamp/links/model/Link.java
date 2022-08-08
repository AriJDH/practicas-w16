package com.bootcamp.links.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    private String value;
    private boolean valid;
    private int count;
    private String password;
}
