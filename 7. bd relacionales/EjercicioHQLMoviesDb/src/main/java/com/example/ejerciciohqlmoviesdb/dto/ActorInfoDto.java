package com.example.ejerciciohqlmoviesdb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActorInfoDto {
    private Integer id;

    private String first_name;

    private String last_name;

    private Date created_at;
    private Date updated_at;

    private long rating;
}
