package com.grodriguez.linkTracker.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private int id;
    private String password;
    private String url;
    private int redireccions;
    private boolean isValid;
}
