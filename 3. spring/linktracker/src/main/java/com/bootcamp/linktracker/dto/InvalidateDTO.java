package com.bootcamp.linktracker.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvalidateDTO {
    private String message;
    private String link;
}
