package integradores.integrador1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepoFacturas implements Repositorio<Factura> {

    private Map<Long,Factura> facturas;
    private Long id;

    public RepoFacturas(){
        this.facturas = new HashMap<>();
    }

    @Override
    public void add(Factura obj) {
        obj.setID(id);
        this.facturas.put(id, obj);
        id++;
    }

    @Override
    public void delete(Long id) {
        this.facturas.remove(id);
    }

    @Override
    public void update(Factura obj, Factura newObj) {
        delete(obj.getID());
        add(newObj);
    }

    @Override
    public Factura get(Long id) {
        return this.facturas.get(id);
    }

    @Override
    public boolean has(Long id) {
        return this.facturas.containsKey(id);
    }

    @Override
    public List<Factura> getAll() {
        return this.facturas.values().stream().collect(Collectors.toList());
    }

}
