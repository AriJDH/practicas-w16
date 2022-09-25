package com.relaciones.jpa.entities.oneToOne;

import com.relaciones.jpa.entities.oneToOne.Address;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    //RELACIÓN UNO A UNO (Propietario)
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name ="address_id", referencedColumnName = "id")
    private Address address;

}
