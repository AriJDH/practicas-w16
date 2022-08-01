import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario;
    private int contador = 1;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> prendasAGuardar) {
        Integer key = contador;
        diccionario.put(key, prendasAGuardar);
        contador++;
        return key;
    }

    public void mostrarPrendas(){
        for (Integer key: diccionario.keySet()){
            List<Prenda> listaDePrendas = diccionario.get(key);
            System.out.println(listaDePrendas);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> prendas = diccionario.remove(numero);//o get(numero)
        return prendas;
    }

}
