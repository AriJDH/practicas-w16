package com.relaciones.jpa.entities.oneToMany;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    //RELACION UNO A MUCHOS (el MANY): el nuevo campo cart_id (one) se  crea en la tabla items (many)
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

}
