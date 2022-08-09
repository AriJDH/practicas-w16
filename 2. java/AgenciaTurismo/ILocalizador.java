package AgenciaTurismo;

import java.util.List;

public interface ILocalizador {
    public List<IReserva> getReservas();
    public void agregarReserva(IReserva reserva);
    public double getPrice();
}
