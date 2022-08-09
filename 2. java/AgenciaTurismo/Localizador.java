package AgenciaTurismo;

import java.util.List;

public class Localizador implements ILocalizador {
    private List<IReserva> reservas;
    private int boletosViaje;
    private int hotel;
    private int restaurant;
    private int transporte;
    public Localizador(List<IReserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return super.toString();
    }
@Override
    public List<IReserva> getReservas() {
        return reservas;
    }
@Override
    public void agregarReserva(IReserva reserva) {
        this.reservas.add(reserva);
    }
    @Override
    public double getPrice() {
        return 0d;
    }
}
