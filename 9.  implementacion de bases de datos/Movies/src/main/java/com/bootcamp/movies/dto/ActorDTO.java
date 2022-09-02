package com.bootcamp.movies.dto;

import com.bootcamp.movies.model.Movie;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {
    private String firstName;
    private String lastName;
    private Integer rating;
}
