package com.movies.movies.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Series {
    @Id
    Integer id;
    LocalDate created_at;
    LocalDate updated_at;
    String title;
    LocalDate release_date;
    LocalDate end_date;
    Integer genre_id;
}
