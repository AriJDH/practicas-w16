package com.bootcamp.linktracker.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Link {
    private Integer linkId;
    private String link;
    private String password;
    private Integer count;

    public Link() { this.count = 0; }
    public void sumCount() { count++; }
}
