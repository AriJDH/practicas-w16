package com.compound.compoundbuy.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;



@Data
@Entity
@Table(name = "pucharse")
@IdClass(value = PucharseKey.class)
public class Pucharse {

    @Id
    private Integer clientId;
    @Id
    private LocalDate date_pucharse;
    private Integer amount_products;

}
