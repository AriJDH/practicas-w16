package DAKAR;

public class SocorristaMoto extends Vehiculo{
    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int cantRuedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, cantRuedas);
    }
    public void socorrerMoto(Moto moto){
        System.out.println("Socorriendo moto "+ moto.getPatente());
    }
}
