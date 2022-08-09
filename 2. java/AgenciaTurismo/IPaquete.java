package AgenciaTurismo;

import java.util.List;

public interface IPaquete extends IReserva {
    public List<IReserva> getReservas();
    public void setReservas(List<IReserva> reservas);
}
