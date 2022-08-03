package com.bootcamp.deportistas.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleticPersonDto {
    private String firstName;
    private String lastName;
    private String sport;
}
