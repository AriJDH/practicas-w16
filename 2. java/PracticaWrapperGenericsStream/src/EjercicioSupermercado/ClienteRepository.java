package EjercicioSupermercado;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements Icrud<Cliente>{

    public List<Cliente> clientes;

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public Cliente create(Cliente cliente) {

        clientes.add(cliente);

        System.out.println("Agregado al sistema.");

        return cliente;
    }

    @Override
    public Cliente get(String doc) {
        return clientes.stream().filter(x -> x.getCi().equals(doc)).findFirst().orElse(null);
    }

    @Override
    public void remove(String doc) {
        clientes.removeIf(x -> x.getCi().equals(doc));
    }

    @Override
    public void update(Cliente c) {

        Cliente c_repo = clientes.stream().filter(x -> x.getCi().equals(c.getCi())).findFirst().orElse(null);
        c_repo.setNombre(c.getNombre());
        c_repo.setApellido(c.getApellido());

        System.out.println("Editado correctamente");
    }

    public void addCliente(Cliente c){
        clientes.add(c);
    }
}
