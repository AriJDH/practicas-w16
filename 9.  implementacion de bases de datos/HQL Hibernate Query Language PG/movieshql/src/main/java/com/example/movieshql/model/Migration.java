package com.example.movieshql.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Migration {

    @Id
    private Integer id;
    private String migration;
    private Integer batch;
}
