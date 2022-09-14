package com.meli.deportista.Dto;

import com.meli.deportista.Entity.People;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportPeopleDto {
    private String name;
    private String lastName;
    private String sport;

}
