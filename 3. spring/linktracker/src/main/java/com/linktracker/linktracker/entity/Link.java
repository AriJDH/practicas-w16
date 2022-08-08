package com.linktracker.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private String link;
    private String password;
    private String ID;
    private int redirections;
    private boolean valid;
}
