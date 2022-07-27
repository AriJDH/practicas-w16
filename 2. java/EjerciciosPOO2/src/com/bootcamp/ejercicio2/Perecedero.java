package com.bootcamp.ejercicio2;

public class Perecedero extends  Producto{
  private Integer diasPorCaducar;

  public Integer getDiasPorCaducar() {
    return diasPorCaducar;
  }

  public void setDiasPorCaducar(Integer diasPorCaducar) {
    this.diasPorCaducar = diasPorCaducar;
  }

  public Perecedero(Integer diasPorCaducar, String nombre, Double precio) {
    super(nombre, precio);
    this.diasPorCaducar = diasPorCaducar;
  }

  @Override
  public String toString() {
    return "Perecedero {" +
            "diasPorCaducar=" + diasPorCaducar +
            '}';
  }

  @Override
  public Double calcular(Integer cantidadDeProductos){
    Double precioAuxiliar = this.getPrecio() * cantidadDeProductos;
    if(this.diasPorCaducar == 3) return precioAuxiliar/2;
    if(this.diasPorCaducar == 2) return precioAuxiliar/3;
    if(this.diasPorCaducar == 1) return precioAuxiliar/4;
    return precioAuxiliar;
  }


}
