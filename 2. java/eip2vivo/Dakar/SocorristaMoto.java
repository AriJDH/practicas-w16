package eip2vivo.Dakar;

public class SocorristaMoto extends Vehiculo{

    public SocorristaMoto(Integer velocidad, Integer aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }


    public void socorrer(Motos unaMoto) {
        System.out.println("Socorriendo moto: Patente " + unaMoto.getPatente());
    }
}
