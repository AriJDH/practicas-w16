package com.bootcamp.link.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private String url;
    private String password;
    private int redirects;
    private boolean isValid;

    public void incrementRedirect() {
        this.redirects++;
    }
}
