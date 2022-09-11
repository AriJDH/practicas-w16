package com.example.spring.hqlpractica.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorDto {

    private String firstName;
    private String lastName;
    private Double rating;
    private MovieDto favoriteMovie;

}
