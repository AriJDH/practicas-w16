package integradores.integrador1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepoFacturas implements Repositorio<Factura> {

    private Map<Integer,Factura> facturas;
    private int id;

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
    public void delete(Factura obj) {
        this.facturas.remove(obj);
    }

    @Override
    public void update(Factura obj, Factura newObj) {
        delete(obj);
        add(newObj);
    }

    @Override
    public Factura get(String id) {
        return this.facturas.get(id);
    }

    @Override
    public boolean has(String id) {
        return this.facturas.containsKey(id);
    }

    public List<Factura> getFacturas() {
        return this.facturas.values().stream().collect(Collectors.toList());
    }

    public int getLastID(){
        return id-1;
    }
}
