import clases.Carrera;
import clases.SocorristaAuto;
import clases.SocorristaMoto;

public class Dakar {

   public static void main(String[] args) {

      Carrera carrera1 = new Carrera(100,50,"Dakar",5);

      carrera1.darDeAltaAuto(180, 60, 8,"A001");
      carrera1.darDeAltaAuto(200,50,4,"A002");
      carrera1.darDeAltaAuto(300,40,2,"A003");
      carrera1.darDeAltaMoto(260, 13, 8, "M001");

      carrera1.eliminarVehiculoConPatente("A001");

      SocorristaMoto socorristaMoto = new SocorristaMoto();
      SocorristaAuto socorristaAuto = new SocorristaAuto();

      carrera1.setSocorristaAuto(socorristaAuto);
      carrera1.setSocorristaMoto(socorristaMoto);

      carrera1.SocorrerAuto("A002");
      carrera1.SocorrerMoto("M001");

      System.out.println(carrera1.definirGanador());

   }
}
