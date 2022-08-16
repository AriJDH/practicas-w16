package bootcamp.supermecado.repository;

import bootcamp.supermecado.entity.Factura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class FacturaRepository implements ICrudRepository{

    private static Collection<Factura> facturas = new ArrayList<>();

    @Override
    public void crear(Object o) {
        facturas.add((Factura) o);
    }

    @Override
    public Object get(Integer id) {
        return facturas.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public void eliminar(Integer id) {
        facturas.removeIf(x -> x.getId().equals(id));
    }

    @Override
    public Collection<Object> getTodos() {
        return Collections.singleton(facturas);
    }

    public Collection<Factura> getByCliente(Integer id){
        return facturas.stream()
                .filter(x -> x.getCliente().getDni().equals(id))
                .collect(Collectors.toList());
    }


}
