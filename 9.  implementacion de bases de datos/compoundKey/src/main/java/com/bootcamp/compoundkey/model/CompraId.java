package com.bootcamp.compoundkey.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompraId implements Serializable {
  private Integer clienteId;
  private LocalDate fechaCompra;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CompraId compraId = (CompraId) o;
    return clienteId.equals(compraId.clienteId) && fechaCompra.equals(compraId.fechaCompra);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clienteId, fechaCompra);
  }
}
