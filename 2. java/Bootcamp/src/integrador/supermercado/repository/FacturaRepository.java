package integrador.supermercado.repository;

import integrador.supermercado.interfaces.IRepository;
import integrador.supermercado.models.Factura;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaRepository implements IRepository<Factura, Integer> {
    private List<Factura> detallesFactura;
    private Integer id;

    public static FacturaRepository instance;

    private FacturaRepository() {
        this.detallesFactura = new ArrayList<>();
        this.id = 1;
    }

    public static FacturaRepository getInstance(){
        if(instance == null) instance = new FacturaRepository();
        return instance;
    }

    @Override
    public Optional<Factura> findOne(Integer identificador) {
        return this.detallesFactura.stream()
                .filter(c->c.getId().equals(identificador))
                .findFirst();
    }

    @Override
    public List<Factura> getAll() {
        return this.detallesFactura;
    }

    @Override
    public Factura save(Factura object) {
        object.setId(this.id++);
        this.detallesFactura.add(object);
        return object;
    }

    @Override
    public Boolean delete(Integer identificador) {
        Optional<Factura> factura = this.findOne(identificador);
        if(factura.isEmpty()) return Boolean.FALSE;
        this.detallesFactura.remove(factura.get());
        return Boolean.TRUE;
    }
}
