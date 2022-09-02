package com.example.ejerciciomovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {


    private String firstName;

    private String lastName;

    private Integer rating;



    public ActorDto(String firstName, String lastName, Double rating) {
    }
}