import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Nike","championes");
        Prenda prenda2= new Prenda("Adidas","remera");
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);
        GuardarRopa roperia = new GuardarRopa();
        int identificador = roperia.guardarRopa(prendas);
        System.out.println("Su Numero identificador es: "+identificador);
        List<Prenda> devueltas= roperia.devolverPrendas(identificador);
        for(Prenda p : devueltas){
            System.out.println(p.toString());
        }
    }
}
