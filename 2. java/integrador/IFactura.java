package integrador;

import java.util.List;

public interface IFactura {
    Double getTotal();
    void setTotal(Double total);
    ICliente getCliente();
    void setCliente(ICliente cliente);
    List<IItemFactura> getItems();
    void setItems(List<IItemFactura> items);
    Integer getId();
    void setId(Integer id);
}
