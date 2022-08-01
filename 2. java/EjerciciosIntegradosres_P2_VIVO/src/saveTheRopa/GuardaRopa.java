package saveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> listaPrendas = new HashMap<Integer, List<Prenda>>();
    private int counterPrendas = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        counterPrendas++;
        listaPrendas.put(counterPrendas,listaDePrenda);
        return counterPrendas;
    }
    public void mostrarPrendas(){
        for (int i = 1; i<=counterPrendas;i++){
            System.out.println("prendas para el ID: "+i);
            listaPrendas.get(i).forEach(System.out::println);
        }
    }
    public List<Prenda> devolverPrendas(Integer numero) {
        return listaPrendas.get(numero);
    }
}
