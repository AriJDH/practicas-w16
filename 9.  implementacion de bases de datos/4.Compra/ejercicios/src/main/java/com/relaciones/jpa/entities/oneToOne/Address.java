package com.relaciones.jpa.entities.oneToOne;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    //RELACIÓN UNO A UNO (Referencia)
    @OneToOne(mappedBy = "address")
    private User user;
}
