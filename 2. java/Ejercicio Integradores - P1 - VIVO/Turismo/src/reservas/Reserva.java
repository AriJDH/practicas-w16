package reservas;

public abstract class Reserva {
    private Double precio;

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Reserva(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "precio=" + precio +
                '}';
    }

    public void aplicarDescuento(Double indice_descuento){
        precio = precio - precio*(indice_descuento/100);
    };
}
