package com.mercadolibre.bootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Link {
    private int id;
    private String url;
    private int redirectsCounter;
    private boolean isActive;
    private String password;

    public Link(){
        this.redirectsCounter = 0;
        this.isActive = true;
    }

    public void incrementRedirectCounter(){
        redirectsCounter++;
    }

}
