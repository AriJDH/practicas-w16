package com.example.ejerciciohqlmoviesdb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="seasons")
public class Seasons {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;

        @Column(name="created_at")
        private Date created_at;

        @Column(name="updated_at")
        private Date updated_at;

        @Column(name="title")
        private String title;

        @Column(name="number")
        private Integer number;


        @Column(name="release_date")
        private Date release_date;

        @Column(name="end_date")
        private Date end_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serie_id")
    private Series serie;

        @OneToMany(mappedBy = "season")
        private Set<Episodes> episodes;
}
