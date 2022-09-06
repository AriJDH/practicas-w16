package com.bootcamp.showroomsql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "garmet")
public class Garmet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    private String name;

    private String type;

    private String brand;

    private String color;

    private String size;

    private Integer amount;

    private Double price;
}
