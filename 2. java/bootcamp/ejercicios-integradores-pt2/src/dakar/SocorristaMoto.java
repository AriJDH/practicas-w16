package dakar;

public class SocorristaMoto extends Socorrista{

    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo moto: " + vehiculo.patente);
    }
}
