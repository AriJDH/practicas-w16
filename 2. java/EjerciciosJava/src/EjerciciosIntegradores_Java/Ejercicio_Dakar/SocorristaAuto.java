package EjerciciosIntegradores_Java.Ejercicio_Dakar;

public class SocorristaAuto extends Vehiculo{

    public SocorristaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso, Integer ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrer(Auto unAuto){
        System.out.println("Socorriendo auto con patente: " + unAuto.getPatente());
    }
}
