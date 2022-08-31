package com.bootcamp.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;
}
