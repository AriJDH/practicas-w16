package com.bootcamp.modelos;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
  private Cliente cliente;
  private Reserva reserva;
  private Double totalParcial;
  private Double totalDescuento;

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Reserva getReserva() {
    return reserva;
  }

  public void setReserva(Reserva reserva) {
    this.reserva = reserva;
  }

  public Localizador(Cliente cliente) {
    this.cliente = cliente;
  }

  public Double getTotalParcial() {
    return totalParcial;
  }

  public void setTotalParcial(Double totalParcial) {
    this.totalParcial = totalParcial;
  }

  public Double getTotalDescuento() {
    return totalDescuento;
  }

  public void setTotalDescuento(Double totalDescuento) {
    this.totalDescuento = totalDescuento;
  }

  public Localizador(Cliente cliente, List<Producto> reserva) {
    this.cliente = cliente;
    this.reserva = new Reserva(reserva);
    this.totalParcial = reserva.stream().mapToDouble(Producto::getPrecio).sum();
  }

  @Override
  public String toString() {
    return "Localizador{" +
        "cliente=" + cliente +
        ", reserva=" + reserva +
        ", total=" + totalParcial +
        '}';
  }

  public void aplicarDescuento() {

  }

  public Boolean paqueteCompleto(){
    List<TipoProducto> tiposProductos = this.reserva.getProductos().stream()
        .map(Producto::getTipoProducto)
        .collect(Collectors.toList());
    return new HashSet<>(tiposProductos).size() == 4;
  }

  public Boolean descuentoMultiple(){
    //2 hoteles 0 2 boleto
    Long countHoteles = this.reserva.getProductos().stream().filter(productos -> productos.getTipoProducto().equals(TipoProducto.HOTEL)).count();
    Long countBoletos = this.reserva.getProductos().stream().filter(productos -> productos.getTipoProducto().equals(TipoProducto.BOLETO)).count();
    System.out.println(countHoteles>=2 || countBoletos>=2);
    return countHoteles>=2 || countBoletos>=2;
  }
}
