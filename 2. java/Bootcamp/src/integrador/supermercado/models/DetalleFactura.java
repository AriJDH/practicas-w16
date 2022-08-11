package integrador.supermercado.models;

public class DetalleFactura {
    private Integer id;
    private Item item;
    private Integer cantidad;
    private Double precio;
    private Factura factura;

    public DetalleFactura(Item item, Integer cantidad, Factura factura) {
        this.item = item;
        this.precio = item.getPrecio();
        this.cantidad = cantidad;
        this.factura = factura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Double getPrecio() {
        return precio;
    }

    public Double getTotal() {
        return precio * cantidad;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
