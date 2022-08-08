package com.bootcamp.linktacker.entity;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Link {

    private Integer id;
    private String link;
    private boolean valid;
    private String password;
    private Integer metric;

}
