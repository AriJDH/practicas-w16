package com.bootcamp.compoundkey.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "compras")
@IdClass(value = CompraId.class)
public class Compra {

  @Id
  @Column(name = "cliente_id")
  private Integer clienteId;

  @Id
  @Column(name = "fecha_compra")
  private LocalDate fechaCompra;
  private Integer cantidadProductos;
}
