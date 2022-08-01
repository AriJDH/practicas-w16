public class SocorristaMotos extends Vehiculo{
    public SocorristaMotos(int velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrer(Moto moto){
        System.out.println("Socorriendo moto " + moto.getPatente());
    }
}
