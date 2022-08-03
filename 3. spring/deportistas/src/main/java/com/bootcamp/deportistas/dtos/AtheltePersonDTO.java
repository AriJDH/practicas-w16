package com.bootcamp.deportistas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtheltePersonDTO {
    private String firstName;
    private String lastName;
    private String sport;
}
