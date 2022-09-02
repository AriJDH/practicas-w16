package com.movies.movies.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seasons {
    @Id
    Integer id;
    LocalDate created_at;
    LocalDate updated_at;
    String title;
    Integer number;
    LocalDate release_date;
    LocalDate end_date;

    @ManyToOne
    @JoinColumn(name= "serie_id")
    Series serie;
}
