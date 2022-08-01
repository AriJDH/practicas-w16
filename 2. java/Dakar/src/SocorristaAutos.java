public class SocorristaAutos extends Vehiculo{
    public SocorristaAutos(int velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrer(Auto auto){
        System.out.println("Socorriendo auto " + auto.getPatente());
    }
}
