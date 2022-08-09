package AgenciaTurismo;

import java.util.Date;

public interface IReservaTransporte extends IReserva {
    public Date getHorarioSalida();
    public void setHorarioSalida(Date horarioSalida);
    public Date getHorarioEntrada();
    public void setHorarioEntrada(Date horarioEntrada);
}
