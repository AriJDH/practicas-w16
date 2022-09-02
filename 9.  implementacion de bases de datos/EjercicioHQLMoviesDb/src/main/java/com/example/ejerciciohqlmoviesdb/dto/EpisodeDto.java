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
public class EpisodeDto {

    private Integer id;

    private Date created_at;

    private Date updated_at;

    private String title;

    private Integer number;

    private Date release_date;

    private long rating;
}
