package AgenciaTurismo;

import java.util.Date;

public class ReservaHotel extends Reserva implements IReservaHotel {
    private Date horarioCheckIn;
    private Date horarioCheckOut;
    private String nombre;

    public ReservaHotel(Date horarioCheckIn, Date horarioCheckOut, String nombre, double precio, IProducto product) {
        super(precio, product);
        this.horarioCheckIn = horarioCheckIn;
        this.horarioCheckOut = horarioCheckOut;
        this.nombre = nombre;
    }
    @Override
    public Date getHorarioCheckIn() {
        return horarioCheckIn;
    }
    @Override
    public void setHorarioCheckIn(Date horarioCheckIn) {
        this.horarioCheckIn = horarioCheckIn;
    }
    @Override
    public Date getHorarioCheckOut() {
        return horarioCheckOut;
    }
    @Override
    public void setHorarioCheckOut(Date horarioCheckOut) {
        this.horarioCheckOut = horarioCheckOut;
    }
    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
