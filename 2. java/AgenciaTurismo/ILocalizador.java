package AgenciaTurismo;

import java.util.List;

public interface ILocalizador {
    List<IReserva> getReservas();
    void agregarReserva(IReserva reserva);
    int getId();
    void setId(int id);
}
