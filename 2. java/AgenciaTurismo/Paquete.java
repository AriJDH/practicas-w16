package AgenciaTurismo;

import java.util.List;

public class Paquete extends Reserva implements IPaquete {
    List<IReserva> reservas;
    public Paquete(List<IReserva> reservas, IProducto product ) {
        super(reservas
                .stream()
                .map(IReserva::getPrecio)
                .reduce(Double::sum).orElse(0d),
                product
                );
        this.reservas = reservas;
    }

    public List<IReserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<IReserva> reservas) {
        this.reservas = reservas;
        this.setPrecio(reservas
                .stream()
                .map(IReserva::getPrecio)
                .reduce(Double::sum).orElse(0d));
    }
}
