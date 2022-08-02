import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Remera", "Nike");
        Prenda prenda2 = new Prenda("Pantalon","Adidas");

        List<Prenda> prendas = new ArrayList<Prenda>();
        prendas.add(prenda1);
        prendas.add(prenda2);

        Map<Integer,List<Prenda>> armario = new HashMap<Integer, List<Prenda>>();
        GuardarRopa guardarRopa = new GuardarRopa(armario, 0);

        int codigo = guardarRopa.guardarPrendas(prendas);

        guardarRopa.mostrarPrendas();

        List<Prenda> prendasDevueltas = guardarRopa.devolverPrendas(codigo);

//        for (Prenda p:
//             prendasDevueltas) {
//            System.out.println(p.toString());
//        }

        guardarRopa.mostrarPrendas();
    }

}
