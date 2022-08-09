package AgenciaTurismo;

import java.util.Date;

public class ReservaBoletosViaje extends  Reserva implements IReservaBoletosViaje {
    private Date horarioSalida;
    private Date horarioEntrada;
        public ReservaBoletosViaje(double precio, Date horarioSalida, Date horarioEntrada, IProduct product) {
        super(precio, product);
        this.horarioSalida = horarioSalida;
        this.horarioEntrada = horarioEntrada;
    }
    @Override
    public Date getHorarioSalida() {
        return horarioSalida;
    }
    @Override
    public void setHorarioSalida(Date horarioSalida) {
        this.horarioSalida = horarioSalida;
    }
    @Override
    public Date getHorarioEntrada() {
        return horarioEntrada;
    }
    @Override
    public void setHorarioEntrada(Date horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }
}
