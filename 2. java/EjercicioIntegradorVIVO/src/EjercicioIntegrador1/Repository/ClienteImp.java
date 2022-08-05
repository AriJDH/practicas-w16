package EjercicioIntegrador1.Repository;

import EjercicioIntegrador1.Model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository<Cliente> {
    List<Cliente> listaClientes = new ArrayList<Cliente>();

    @Override
    public void save(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Cliente c : listaClientes) {
            System.out.println("DNI: " + c.getDni() + " Nombre: " + c.getNombre() + " Apellido: " + c.getApellido());
        }
    }

    @Override
    public Optional<Cliente> buscar(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscado) {
        boolean bandera = false;

        for (Cliente c : listaClientes) {
            if (c.getDni() == dniBuscado) {
                System.out.println("DNI: " + c.getDni() + " Nombre: " + c.getNombre() + " Apellido: " + c.getApellido());
                return Optional.of(c);
            }
        }
        if (bandera == false) {
            System.out.println("No se encontro cliente");
        } else {
            System.out.println("Se realizo correctamente la busqueda");
        }
        return  Optional.empty();
    }

    @Override
    public void eliminar(Long dniBorrado) {
        Optional<Cliente> cli = this.buscar(dniBorrado);

        if (cli.isEmpty()) {
            System.out.println("No se encontro cliente a eliminar");
        } else {
            System.out.println("Se ha eliminado correctamente el cliente");
            listaClientes.remove(cli.get());
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        for (Cliente c:listaClientes) {
            System.out.println("DNI: " + c.getDni() + " Nombre: " + c.getNombre() + " Apellido: " + c.getApellido());
        }
        return null;
    }
}
