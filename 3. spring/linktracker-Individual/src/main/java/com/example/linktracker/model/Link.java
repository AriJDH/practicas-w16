package com.example.linktracker.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {
    protected String url;
    protected String password;
    protected Integer count;

    public void addCount(){
        count++;
    }
}




