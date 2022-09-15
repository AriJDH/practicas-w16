package com.example.movies.DTO;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ActorDto implements Serializable {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final Double rating;
}
