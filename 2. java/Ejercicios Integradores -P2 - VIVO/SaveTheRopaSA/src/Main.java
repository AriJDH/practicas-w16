import clases.GuardarRopa;
import clases.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda prenda1 = new Prenda("marca1", "modelo1");
        Prenda prenda2 = new Prenda("marca1", "modelo2");
        Prenda prenda3 = new Prenda("marca2", "modelo3");
        Prenda prenda4 = new Prenda("marca2", "modelo4");
        Prenda prenda5 = new Prenda("marca3", "modelo5");

        List<Prenda> listPrendas = new ArrayList<>();
        listPrendas.add(prenda1);
        listPrendas.add(prenda2);
        listPrendas.add(prenda3);
        listPrendas.add(prenda4);
        listPrendas.add(prenda5);

        GuardarRopa guardarRopa = new GuardarRopa();


        Integer posicion =  guardarRopa.guardarPrendas(listPrendas);
        System.out.println(posicion);
        guardarRopa.mostrarPrendas();

        System.out.println(guardarRopa.devolverPrenda(1));

    }
}
