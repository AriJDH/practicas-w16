package supermercado.repositorios;

import supermercado.Factura;
import supermercado.Interfaces.Crud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class FacturaRepositorio implements Crud {

    private static Collection<Factura> facturas = new ArrayList<>();

    @Override
    public void crear(Object o) {
        facturas.add((Factura) o);
    }

    @Override
    public Object get(String id) {
        return facturas.stream().filter(factura -> factura.getId().equals(id)).findFirst().get();
    }

    @Override
    public void eliminar(String id) {
        facturas.removeIf(factura -> factura.getId().equals(id));
    }

    @Override
    public Collection<Object> getTodos() {
        return Collections.singleton(facturas);
    }

    public Collection<Factura> getByCliente(String dni){
        return facturas.stream().filter(factura -> factura.getCliente().getDni().equals(dni)).collect(Collectors.toList());
    }
}
