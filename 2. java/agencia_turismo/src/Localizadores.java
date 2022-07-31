import java.util.List;
import java.util.stream.Collectors;

public class Localizadores {
    private Cliente comprador;
    private double monto;
    private List<Reserva> reservas;
    private Agencia_Turismo agencia;

    public Localizadores(Cliente comprador, double monto, List<Reserva> reservas, Agencia_Turismo agencia) {
        this.comprador = comprador;
        this.reservas = reservas;
        this.agencia=agencia;
        if(agencia.getLocalizadoresClientes(this.comprador).size()>2)
        {
            Long listaHotel= reservas.stream().filter(x-> x.isHotel()).count();
            Long listaViaje= reservas.stream().filter(x-> x.isViajes()).count();

            if(listaHotel>2||listaViaje>2)
            {
                this.monto=monto-(monto*0.05);
            }
            else
            {
                if(comprador.isDescuentoFuturo() )
                {
                    this.monto=monto-(monto*0.05);
                }
                else {
                    comprador.setDescuentoFuturo(true);
                }

            }

        }
        else
        {
            long fin=0;
            List<Localizadores> dscto= agencia.getLocalizadoresClientes(this.comprador);
            for(Localizadores reserva1:dscto)
            {
                List<Reserva> paquete = reserva1.getReservas();

               fin=fin+ paquete.stream().filter(x-> x.paqueteCompleto()).count();

            }
            if(fin>0)
            {
                this.monto=monto-(monto*0.1);
            }
        }



    }

    public Cliente getComprador() {
        return comprador;
    }

    public double getMonto() {
        return monto;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }


}
