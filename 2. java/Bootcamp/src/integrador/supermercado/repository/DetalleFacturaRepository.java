package integrador.supermercado.repository;

import integrador.supermercado.interfaces.IRepository;
import integrador.supermercado.models.DetalleFactura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetalleFacturaRepository implements IRepository<DetalleFactura, Integer> {
    private List<DetalleFactura> detallesFactura;
    private Integer id;

    public static DetalleFacturaRepository instance;

    private DetalleFacturaRepository() {
        this.detallesFactura = new ArrayList<>();
        this.id = 1;
    }

    public static DetalleFacturaRepository getInstance(){
        if(instance == null) instance = new DetalleFacturaRepository();
        return instance;
    }

    @Override
    public Optional<DetalleFactura> findOne(Integer identificador) {
        return this.detallesFactura.stream()
                .filter(c->c.getId().equals(identificador))
                .findFirst();
    }

    @Override
    public List<DetalleFactura> getAll() {
        return this.detallesFactura;
    }

    @Override
    public DetalleFactura save(DetalleFactura object) {
        object.setId(this.id++);
        this.detallesFactura.add(object);
        return object;
    }

    @Override
    public Boolean delete(Integer identificador) {
        Optional<DetalleFactura> detalleFactura = this.findOne(identificador);
        if(detalleFactura.isEmpty()) return Boolean.FALSE;
        this.detallesFactura.remove(detalleFactura.get());
        return Boolean.TRUE;
    }
}
