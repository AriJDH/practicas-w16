package com.bootcamp.modelos;

import java.util.List;

public class Reserva {
  private List<Producto> productos;

  public List<Producto> getProductos() {
    return productos;
  }

  public void setProductos(List<Producto> productos) {
    this.productos = productos;
  }

  public Reserva(){

  }

  public Reserva(List<Producto> productos) {
    this.productos = productos;
  }

  @Override
  public String toString() {
    return "Reserva{" +
        "productos=" + productos +
        '}';
  }
}
