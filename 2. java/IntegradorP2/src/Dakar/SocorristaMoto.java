package Dakar;

public class SocorristaMoto extends Vehiculo{
    public SocorristaMoto() {
    }

    public void socorrer(Moto unaMoto) {
        System.out.println("Socorriendo auto: " + unaMoto.getPatente() + " ...");
    }
}
