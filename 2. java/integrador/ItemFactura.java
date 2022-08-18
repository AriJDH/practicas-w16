package integrador;


public class ItemFactura implements IItemFactura {
    Item item;
    Integer cantidad;

    public ItemFactura(Item item, Integer cantidad) {
        this.item = item;
        this.cantidad = cantidad;
    }

    public ItemFactura() {}

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
