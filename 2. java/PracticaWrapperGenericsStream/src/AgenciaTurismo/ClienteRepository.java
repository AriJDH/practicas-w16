package AgenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> clientes;

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes(){
        return clientes;
    }

    public void addCliente(Cliente cliente){
        if(clientes.stream().filter(x -> x.getNombre() == cliente.getNombre()).count() == 0)
            clientes.add(cliente);
    }
}
