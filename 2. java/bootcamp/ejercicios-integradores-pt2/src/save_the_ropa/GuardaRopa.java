package save_the_ropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> diccionario = new HashMap<>();
    private int contador = 1;

    public Integer guardarPrendas(List<Prenda> listaPrendas){
        diccionario.put(contador, listaPrendas);
        int contadorActual = contador;
        contador++;
        return contadorActual;
    }

    public void mostrarPrendas(){
        diccionario.forEach((integer, prendas) -> {
            System.out.println(integer);
            prendas.forEach(System.out::println);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
      return diccionario.get(numero);
    }
}
