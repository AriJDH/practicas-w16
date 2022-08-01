package clases;

public class Motos extends Vehiculo {
   public Motos(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
      super(velocidad, aceleracion, anguloDeGiro, patente);
      super.setPeso(300);
      super.setRuedas(2);
   }
}
