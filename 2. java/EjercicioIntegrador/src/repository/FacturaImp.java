package repository;

import model.Cliente;
import model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements crudRepository<Factura> {
    List<Factura> listaFacturas = new ArrayList<>();

    @Override
    public void save(Factura obj) {
        listaFacturas.add(obj);
    }

    @Override
    public void mostrarPantalla() {
        listaFacturas.forEach(System.out::println);
    }

    @Override
    public Optional<Factura> buscar(Long id) {
        try
        {
            Factura factura = listaFacturas.stream().filter(c -> c.getCodigo().equals(id)).findFirst().get();
            return Optional.of(factura);

        } catch (Exception e) {
            System.out.println("No se encontro la factura");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {
       Optional<Factura> factura = this.buscar(id);

        if (factura.isEmpty()) {
            System.out.println("No se encontro la factura");
        } else {
            listaFacturas.remove(factura.get());
            System.out.println("factura borrada");
        }
    }

    @Override
    public List<Factura> listar() {
        return listaFacturas;
    }

}
