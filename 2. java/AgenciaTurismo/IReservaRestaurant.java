package AgenciaTurismo;

import java.util.Date;

public interface IReservaRestaurant extends IReserva {
    public Date getHorario();
    public void setHorario(Date horario);
}
