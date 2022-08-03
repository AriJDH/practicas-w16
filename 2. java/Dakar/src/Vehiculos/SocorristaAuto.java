package Vehiculos;

public class SocorristaAuto extends Vehiculo{

    public SocorristaAuto() {
    }

    public void socorrerAuto(Vehiculo unAuto){
        System.out.println("Socorriendo auto: " + unAuto.getPatente());
    }
}
