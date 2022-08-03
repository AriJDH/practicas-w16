package EjercicioIntegrador;

import EjercicioIntegrador.interfaces.RepositoryCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements RepositoryCrud<Items> {
    List<Items> itemsList= new ArrayList<>();

    @Override
    public void guardar(Items objeto) {
        itemsList.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for(Items p:itemsList){
            System.out.println(p);
        }
    }


    @Override
    public Optional<Items> buscar(int codigo) {
        int m=0;
        for (Items p : itemsList) {

            if (codigo == p.getCodigo()) {
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
    public void eliminar(int codigo) {
        int m =0;
        for (Items p : itemsList) {

            if (codigo == p.getCodigo()) {
                itemsList.remove(p);
                System.out.println("se elimino un items");
                m++;
                break;
            }
            if (m <= 0) {
                System.out.println("no se encontro el dni");
            }
        }

    }

    @Override
    public List<Items> traerDatos() {
        return itemsList;
    }
}
