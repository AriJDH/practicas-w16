package AgenciaTurismo;

public interface IReserva {
    public double getPrecio();
    public double getPrecioConDescuentos();
    public double getCantidadDescuento();
    public void setPrecio(double precio);
    public float setAgregarDescuento(float porcentaje);

}
