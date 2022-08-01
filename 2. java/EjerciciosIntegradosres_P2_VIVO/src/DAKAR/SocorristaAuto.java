package DAKAR;

public class SocorristaAuto extends Vehiculo{
    public SocorristaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int cantRuedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, cantRuedas);
    }
    public void socorrerAuto(Auto auto){
        System.out.println("Socorriendo auto "+auto.getPatente());
    }

}
