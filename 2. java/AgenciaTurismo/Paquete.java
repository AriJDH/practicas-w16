package AgenciaTurismo;

import java.util.List;

public class Paquete extends Reserva implements IPaquete {
    List<IReserva> reservas;
    public Paquete(List<IReserva> reservas, IProduct product ) {
        super(reservas
                .stream()
                .map(IReserva::getPrecio)
                .reduce(Double::sum).orElse(0d),
                product
                );
        this.reservas = reservas;
        this.setAgregarDescuento(0.1f);
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
