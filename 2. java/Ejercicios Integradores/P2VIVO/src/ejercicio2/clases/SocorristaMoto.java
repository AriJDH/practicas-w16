package ejercicio2.clases;

public class SocorristaMoto extends Moto{
    public SocorristaMoto(float velocidad, float aceleracion, float anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public void socorrer(Moto unaMoto){
        System.out.println("Socorriendo moto: " + unaMoto.getPatente());
    }
}
