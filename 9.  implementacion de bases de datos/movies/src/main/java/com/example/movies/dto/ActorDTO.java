package com.example.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ActorDTO {
    private Integer id;
    private Date createdAt;
    private Date updateAt;
    private String firstName;
    private String lastName;
    private Double rating;
    private Double favoriteMovie;
}
