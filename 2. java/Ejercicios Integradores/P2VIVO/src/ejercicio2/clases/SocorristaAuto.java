package ejercicio2.clases;

public class SocorristaAuto extends Auto{

    public SocorristaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public void socorrer(Auto unAuto){
        System.out.println("Socorriendo auto: " + unAuto.getPatente());
    }
}
