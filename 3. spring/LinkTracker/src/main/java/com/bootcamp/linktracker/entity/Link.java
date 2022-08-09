package com.bootcamp.linktracker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private String url;
    private String password;

    private int redirects;
    private boolean isActivated;


    public void incrementRedirect(){this.redirects++;}

}
