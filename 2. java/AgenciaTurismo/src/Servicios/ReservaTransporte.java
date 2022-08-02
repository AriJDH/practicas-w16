package Servicios;

public class ReservaTransporte extends Reserva {

    private String proveedor;

    public ReservaTransporte(String numReserva, int costo, String proveedor) {
        super(numReserva, costo);
        this.proveedor = proveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String mostrarDatos() {
        return "***** Reserva de Transporte *****" + "\n"
        + super.mostrarDatos() + "\n"
                + "Proveedor: " + this.getProveedor() + "\n";
    }
}
