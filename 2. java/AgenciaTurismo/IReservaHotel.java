package AgenciaTurismo;

import java.util.Date;

public interface IReservaHotel extends IReserva {
    public Date getHorarioCheckIn();
    public void setHorarioCheckIn(Date horarioCheckIn);
    public Date getHorarioCheckOut();
    public void setHorarioCheckOut(Date horarioCheckOut);
    public String getNombre();
    public void setNombre(String nombre);
}
