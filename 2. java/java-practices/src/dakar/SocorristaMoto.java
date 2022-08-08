package dakar;

public class SocorristaMoto extends VehiculoSocorrista{
    @Override
    public void socorrer(String patente) {
        System.out.println("Socorriendo Moto " + patente );
    }
}
