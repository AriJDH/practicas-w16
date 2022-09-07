package com.example.Claves.Compuestas;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    private Long clienteId;

    @Id
    private Date fecha;

    private Long compraId;

    private String articulo;

    private Double precio;
}
