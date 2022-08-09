package com.bootcamp.linktracker.dto;

import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkResponseDTO {
    private Integer linkId;
    private String password;
}
