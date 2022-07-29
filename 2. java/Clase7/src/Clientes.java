import java.util.ArrayList;

public class Clientes {
    protected ArrayList<Cliente> clientes;

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Clientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "clientes=" + clientes +
                '}';
    }
}
