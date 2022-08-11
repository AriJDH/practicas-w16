package AgenciaTurismo;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Paquete> paquetes;

    private double total;

    public Localizador(Cliente cliente, List<Paquete> paquetes, double total) {
        this.cliente = cliente;
        this.paquetes = paquetes;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void aplicarDescuento(int porcentaje){
        this.total = this.total - (this.total/100*porcentaje);
    }

    public boolean verificarDescuentoPqueteCompleto(){
        boolean ret = false;
        for (Paquete p: paquetes) {
            if(p.esCompleto())
                ret = true;
        }
        return ret;
    }

    public boolean verificarDescuentoResrvasOBoletos(){
        boolean ret = false;
        int reservas = 0;
        int boletos = 0;

        for (Paquete p: paquetes) {
            if(p.isReservaHotel())
                reservas++;

            if (p.isBoletos())
                boletos++;
        }

        return reservas >= 2 || boletos >= 2;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", paquetes=" + paquetes +
                ", total=" + total +
                '}';
    }
}
