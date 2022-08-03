import java.util.ArrayList;

import java.util.List;

public class Main {



    public static void main(String[] args) {

        List<Prenda> listaPrenda = new ArrayList<>();
        listaPrenda.add(new Prenda("nike","jordan"));
        listaPrenda.add(new Prenda("adidas","jeasy"));

        GuardaRopa guardaRopa = new GuardaRopa();

       int codigo= guardaRopa.guardarPrendas(listaPrenda);
       
       guardaRopa.devolverPrendas(codigo).forEach(System.out::println);



    }


}
