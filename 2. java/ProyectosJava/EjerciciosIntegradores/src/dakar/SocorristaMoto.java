package dakar;

public class SocorristaMoto extends Vehiculo{


    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public void socorrerMoto(Moto unaMoto){

        System.out.println("Socorriendo moto: "+unaMoto.getPatente());

    };
}
