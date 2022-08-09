package AgenciaTurismo;

public class Reserva implements IReserva, IProduct {
    private double precio;
    private float porcentajeDescuento;
    private IProduct product;
    public Reserva(double precio, IProduct product) {
        this.precio = precio;
        this.porcentajeDescuento = 0;
        this.product = product;
    }
@Override
    public double getPrecio() {
        return this.precio;
    }
    @Override
    public double getPrecioConDescuentos() {
        return this.precio - this.getCantidadDescuento();
    }
    @Override
    public double getCantidadDescuento() {
        return this.precio * this.porcentajeDescuento;
    }
    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    @Override
    public float setAgregarDescuento(float porcentaje) {
        //TODO validaciones
        return this.porcentajeDescuento + porcentaje;
    }


    @Override
    public void setName(String name) {
        this.product.setName(name);
    }

    @Override
    public String getName() {
        return this.product.getName();
    }
}
