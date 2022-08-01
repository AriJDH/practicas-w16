package EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo;

import java.util.ArrayList;
import java.util.List;

public class Clientes {
    private List<Cliente> clientes;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Clientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "clientes=" + clientes +
                '}';
    }
}
