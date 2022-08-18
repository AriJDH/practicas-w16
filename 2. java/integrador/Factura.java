package integrador;

import java.util.ArrayList;
import java.util.List;

public class Factura implements IFactura {
    private Integer id;
    private Double total;
    private ICliente cliente;
    private List<IItemFactura> items;
    static Integer nextId = 0;
    public Factura() {
        this.id = this.nextId++;
        this.items = new ArrayList<>();
    }
    public Factura(Double total, Cliente cliente) {
        this.id = this.nextId++;
        this.items = new ArrayList<>();
        this.total = total;
        this.cliente = cliente;
    }
    @Override
    public Double getTotal() {
        return total;
    }
    @Override
    public void setTotal(Double total) {
        this.total = total;
    }
    @Override
    public ICliente getCliente() {
        return cliente;
    }
    @Override
    public void setCliente(ICliente cliente) {
        this.cliente = cliente;
    }
    @Override
    public List<IItemFactura> getItems() {
        return items;
    }
    @Override
    public void setItems(List<IItemFactura> items) {
        this.items = items;
    }
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
