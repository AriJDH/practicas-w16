package AgenciaTurismo;

public interface IReserva {
    double getPrecio();
    void setPrecio(double precio);
    IProducto getProduct();
    void setProduct(IProducto product);
}
