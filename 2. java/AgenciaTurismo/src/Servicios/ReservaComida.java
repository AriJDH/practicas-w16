package Servicios;

public class ReservaComida extends Reserva {
    private String tipoDeMenu;

    public ReservaComida(String numReserva, int costo, String tipoDeMenu) {
        super(numReserva, costo);
        this.tipoDeMenu = tipoDeMenu;
    }

    public String getTipoDeMenu() {
        return tipoDeMenu;
    }

    public void setTipoDeMenu(String tipoDeMenu) {
        this.tipoDeMenu = tipoDeMenu;
    }

    @Override
    public String mostrarDatos() {
        return "***** Reserva de Comida *****" + "\n"
        + super.mostrarDatos() + "\n"
                + "Tipo de Menú: " + this.getTipoDeMenu() + "\n";
    }
}
