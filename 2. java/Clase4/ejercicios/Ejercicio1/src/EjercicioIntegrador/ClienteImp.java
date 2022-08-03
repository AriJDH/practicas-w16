package EjercicioIntegrador;

import EjercicioIntegrador.interfaces.RepositoryCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements RepositoryCrud<Clientes> {

    List<Clientes> clientesList= new ArrayList<>();
    @Override
    public void guardar(Clientes objeto) {
        clientesList.add(objeto);

    }

    @Override
    public void mostrarPantalla() {
        for(Clientes p:clientesList){
            System.out.println("Nombre: "+ p.getNombre());
            System.out.println("Apellido: "+ p.getApellido());
            System.out.println("Dni: "+ p.getDni());
        }
    }

    @Override
    public Optional<Clientes> buscar(int dni) {
        int m=0;
        for (Clientes p : clientesList) {

            if (dni == p.getDni()) {
                System.out.println("Nombre: "+ p.getNombre());
                System.out.println("Apellido: "+ p.getApellido());
                System.out.println("Dni: "+ p.getDni());
                m++;
                return Optional.of(p);
            }
            if (m <= 0) {
                System.out.println("no se encontro el dni");
            }
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(int dni) {
        int m =0;
        for (Clientes p : clientesList) {

            if (dni == p.getDni()) {
                clientesList.remove(p);

                m++;
                break;
            }
            if (m <= 0) {
                System.out.println("no se encontro el dni");
            }
        }
    }

    @Override
    public List<Clientes> traerDatos() {
        return clientesList;
    }
}
