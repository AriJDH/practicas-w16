package com.bootcamp.modelos;

import java.util.List;

public class Garaje {
  private String id;
  private List<Vehiculo> vehiculos;

  public Garaje(List<Vehiculo> vehiculos) {
    this.vehiculos = vehiculos;
  }

  public Garaje(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Vehiculo> getVehiculos() {
    return vehiculos;
  }

  public void setVehiculos(List<Vehiculo> vehiculos) {
    this.vehiculos = vehiculos;
  }

  @Override
  public String toString() {
    return "Garaje {" +
        "vehiculos = \n" + vehiculos +
        "}";
  }
}
