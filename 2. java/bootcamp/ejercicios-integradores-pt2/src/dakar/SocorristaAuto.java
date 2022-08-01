package dakar;

public class SocorristaAuto extends Socorrista{

    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo auto: "+ vehiculo.patente);
    }
}
