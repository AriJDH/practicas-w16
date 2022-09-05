package com.example.jparelation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "compra")
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private Long id;
    @Id
    @Column(name = "fecha_compra")
    private Date fechaCompra;
    @Column(name = "nombre_cliente")
    private String nombreCliente;


}
