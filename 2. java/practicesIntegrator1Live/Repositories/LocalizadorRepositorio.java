package practicesIntegrator1Live.Repositories;

import practicesIntegrator1Live.models.Cliente;
import practicesIntegrator1Live.models.Localizador;
import practicesIntegrator1Live.models.Repositorio;
import practicesIntegrator1Live.models.TipoProducto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalizadorRepositorio implements Repositorio<Localizador> {
  private List<Localizador> localizadores;
  @Override
  public void guardar(Localizador localizador) {
    aplicarDescuentos(localizador);
    this.localizadores.add(localizador);
  }

  @Override
  public void eliminar(Localizador localizador) {

  }

  @Override
  public void imprimir(Localizador localizador) {

  }

  public LocalizadorRepositorio() {
    this.localizadores = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "LocalizadorRepositorio{" +
        "localizadores=" + localizadores +
        '}';
  }

  private void aplicarDescuentos(Localizador localizador) {
    Double descuento = 1.0;
    if(descuentoClienteFrecuente(localizador)) descuento -= 0.05;
    if(localizador.paqueteCompleto()) descuento -= 0.1;
    if(localizador.descuentoMultiple()) descuento -= 0.05;
    localizador.setTotalDescuento(localizador.getTotalParcial() * descuento);
  }

  public Boolean descuentoClienteFrecuente(Localizador localizador){
    Cliente cliente = localizador.getCliente();
    Long a = this.localizadores.stream()
        .filter(l -> l.getCliente().getDni().equals(cliente.getDni()))
        .count();
    return a>=2;
  }

  public int cantidadLocalizadoresVendidos() {
    return localizadores.size();
  }

  public void diccionarioReservas() {
    Map<Integer, String> mapReservas = new HashMap<>();

    localizadores.forEach(x -> {

      x.getReserva().getProductos().stream().forEach(v -> {
        switch (v.getTipoProducto()) {
          case HOTEL: mapReservas.put(1,TipoProducto.HOTEL.toString());
          case BOLETO: mapReservas.put(2,TipoProducto.BOLETO.toString());
          case COMIDA: mapReservas.put(3,TipoProducto.COMIDA.toString());
          case TRANSPORTE: mapReservas.put(4,TipoProducto.TRANSPORTE.toString());
        }
      });
    });

    mapReservas.forEach((key, value) -> {
      System.out.println(key + "--" + value);
    });
  }

  public double totalVentas() {
    double countTotal = 0;

    for (Localizador item: localizadores) {
      countTotal = item.getTotalParcial() + countTotal;
    }

    return countTotal;
  }

  public double promedioVentas() {
    double promedioTotal = 0;

    promedioTotal = totalVentas() / cantidadLocalizadoresVendidos();

    return promedioTotal;
  }
}
