package AgenciaTurismo;

import java.util.Date;

public class ReservaRestaurant extends Reserva implements IReservaRestaurant{
    Date horario;
    public ReservaRestaurant(double precio, Date horario, IProducto product) {
        super(precio, product);
        this.horario = horario;
    }
    @Override
    public Date getHorario() {
        return horario;
    }
    @Override
    public void setHorario(Date horario) {
        this.horario = horario;
    }
}
