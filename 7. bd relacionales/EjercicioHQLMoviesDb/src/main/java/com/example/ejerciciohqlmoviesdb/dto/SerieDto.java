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
public class SerieDto {

    private Integer id;

    private Date created_at;

    private Date updated_at;

    private String title;

    private Date release_date;

    private Date end_date;
}
