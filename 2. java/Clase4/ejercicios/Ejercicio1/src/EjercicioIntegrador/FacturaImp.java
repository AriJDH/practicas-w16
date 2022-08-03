package EjercicioIntegrador;

import EjercicioIntegrador.interfaces.RepositoryCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements RepositoryCrud<Factura> {
    List<Factura> facturaList= new ArrayList<>();

    @Override
    public void guardar(Factura objeto) {
        facturaList.add(objeto);

    }

    @Override
    public void mostrarPantalla() {
        for(Factura l:facturaList){
            System.out.println(l);
        }
    }

    @Override
    public Optional<Factura> buscar(int codigo) {
        int m=0;
        for (Factura p : facturaList) {

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
        for (Factura p : facturaList) {

            if (codigo == p.getCodigo()) {
                facturaList.remove(p);
                System.out.println("se elimino una factura");

                m++;
                break;
            }
            if (m <= 0) {
                System.out.println("no se encontro el dni");
            }
        }
    }

    @Override
    public List<Factura> traerDatos() {
        return facturaList;
    }
}
