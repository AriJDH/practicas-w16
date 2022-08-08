package com.bootcamp.linktacker.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class AllInfoLinkDto {

    private Integer id;
    private String link;
    private boolean valid;
}
