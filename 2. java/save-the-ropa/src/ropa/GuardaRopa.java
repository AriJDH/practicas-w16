package ropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private final Map<Integer, List<Prenda>> guardaropa = new HashMap<>();
    private Integer counter = 0;

    public Integer guardarPrendas(List<Prenda> lista) {
        guardaropa.put(++counter, lista);
        return counter;
    }

    public void mostrarPrendas() {
        System.out.println(guardaropa);
    }

    public List<Prenda> devolverPrendas(Integer num) {
        if(guardaropa.containsKey(num)) {
            List<Prenda> lista = guardaropa.get(num);
            guardaropa.remove(num);
            return lista;
        }
        return null;
    }
}
