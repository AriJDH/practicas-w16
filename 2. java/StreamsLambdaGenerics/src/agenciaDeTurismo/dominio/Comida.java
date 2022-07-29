package agenciaDeTurismo.dominio;

public class Comida extends Reserva {

    public Comida(double costoMenu) {
        this.costoMenu = costoMenu;
    }

    private double costoMenu;


    @Override
    public double getCosto() {
        return this.costoMenu;
    }
}
