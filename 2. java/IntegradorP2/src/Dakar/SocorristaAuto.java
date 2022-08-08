package Dakar;

public class SocorristaAuto extends Vehiculo{
    public SocorristaAuto() {
    }

    public void socorrer(Auto unAuto) {
        System.out.println("Socorriendo auto: " + unAuto.getPatente() + " ...");
    }
}
