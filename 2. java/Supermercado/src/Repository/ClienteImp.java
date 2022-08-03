package Repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClienteImp implements CRUDRepository <Cliente>{
    List<Cliente> listaDeClientes = new ArrayList<>();
    @Override
    public void save(Cliente objeto) {
        listaDeClientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Cliente c: listaDeClientes) {
            System.out.println(c.toString());
        }
    }

    @Override
    public Optional<Cliente> buscar(String dniBuscado) {
        for (Cliente c : listaDeClientes){
            if(Objects.equals(c.getDni(), dniBuscado)){
                System.out.println("Cliente solicitado: ");
                System.out.println(c);
                // break; aca no puedo poner el break pues no tenemos una secuencialidad
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Cliente> traerTodos() {
        return null;
    }
}
