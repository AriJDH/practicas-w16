package agenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio implements Repositorio<Cliente>{
  private List<Cliente> clientes;

  @Override
  public void guardar(Cliente cliente) {
    this.clientes.add(cliente);
  }

  @Override
  public void eliminar(Cliente cliente) {

  }

  @Override
  public void imprimir(Cliente cliente) {

  }

  public ClienteRepositorio() {
    this.clientes = new ArrayList<Cliente>();
  }

  @Override
  public String toString() {
    return "ClienteRepositorio{" +
        "clientes=" + clientes +
        '}';
  }
}
