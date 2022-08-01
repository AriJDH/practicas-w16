import java.util.ArrayList;

import clases.GuardaRopa;
import clases.Prenda;

public class SaveTheRopa {
   public static void main(String[] args) {

      GuardaRopa guardaRopa = new GuardaRopa();

      Prenda remera = new Prenda("Adidas","DryFit");
      Prenda pantalon = new Prenda("Puma","Black");

      ArrayList<Prenda> listaPrendas1 = new ArrayList<>();

      Prenda camisa =  new Prenda("Bowen", "Street");
      Prenda bermuda = new Prenda("Signs","Beach");

      ArrayList<Prenda> listaPrendas2 = new ArrayList<>();

      listaPrendas1.add(remera);
      listaPrendas1.add(pantalon);
      listaPrendas2.add(camisa);
      listaPrendas2.add(bermuda);

      guardaRopa.guardarPrendas(listaPrendas2);
      guardaRopa.guardarPrendas(listaPrendas1);
      guardaRopa.mostrarPrendas();

      System.out.println(guardaRopa.devolverPrendas(2));

   }
}
