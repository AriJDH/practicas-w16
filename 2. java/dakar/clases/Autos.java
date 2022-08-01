package clases;

public class Autos extends Vehiculo {

   public Autos(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
      super(velocidad, aceleracion, anguloDeGiro, patente);
      super.setPeso(1000);
      super.setRuedas(4);
   }

}
