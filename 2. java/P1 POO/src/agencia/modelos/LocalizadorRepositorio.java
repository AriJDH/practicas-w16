package agencia.modelos;

import java.util.ArrayList;
import java.util.List;

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
    this.localizadores = new ArrayList<Localizador>();
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
}
