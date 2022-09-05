package com.emeli.showroom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clothing")
public class Clothing {

    @Id
    private String id;

    private String name;

    private String type;

    private String brand;

    private String color;

    private String size;

    private Integer amount;

    private Double price;
}
