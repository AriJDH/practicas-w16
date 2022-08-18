package AgenciaTurismo;

public class Reserva implements IReserva {
    private double precio;
    private IProducto producto;
    public Reserva() {}
    public Reserva(double precio, IProducto producto) {
        this.precio = precio;
        this.producto = producto;
    }
    @Override
    public double getPrecio() {
        return this.precio;
    }
    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    @Override
    public IProducto getProduct() {
        return producto;
    }
    @Override
    public void setProduct(IProducto product) {
        this.producto = product;
    }
}
