package clientes;

import java.util.ArrayList;
import java.util.List;

public class Clientes {
    private List<Cliente> listaCliente = new ArrayList<>();

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public void addCliente(Cliente cliente){
        this.listaCliente.add(cliente);
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "listaCliente=" + listaCliente +
                '}';
    }
}
