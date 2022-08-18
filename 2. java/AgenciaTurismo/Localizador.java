package AgenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Localizador implements ILocalizador {
    static int nextId = 0;
    private int id;
    private List<IReserva> reservas;
    public Localizador() {
        this.reservas = new ArrayList<>();
        this.id = this.nextId++;
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
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

}
