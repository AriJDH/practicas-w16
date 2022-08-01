package integradores.integrador1;

import java.util.ArrayList;
import java.util.List;

public class RepoFacturas implements Repositorio<Factura> {

    private List<Factura> facturas;

    public RepoFacturas(){
        this.facturas = new ArrayList<>();
    }

    @Override
    public void add(Factura obj) {
        this.facturas.add(obj);
    }

    @Override
    public void delete(Factura obj) {
        this.facturas.remove(obj);
    }

    @Override
    public void update(Factura obj, Factura newObj) {
        this.facturas.remove(obj);
        this.facturas.add(newObj);
    }

    public List<Factura> getFacturas() {
        return this.facturas;
    }
}
