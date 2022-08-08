package dakar;

public class SocorristaAuto extends VehiculoSocorrista{
    @Override
    public void socorrer(String patente) {
        System.out.println("Socorriendo Auto: " + patente);
    }
}
