package com.bootcamp.movieshql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorFilterMovieTitleDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private Double rating;

}
