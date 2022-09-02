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
public class MovieDto {
    private Integer id;

    private Date created_at;

    private Date updated_at;

    private String title;

    private Long rating;

    private Integer awards;

    private Date release_date;

    private Integer length;
}
