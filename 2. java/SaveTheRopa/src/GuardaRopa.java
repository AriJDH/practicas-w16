import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer contador;
    private Map<Integer, List<Prenda>> diccionario;

    public GuardaRopa() {
        this.contador = 0;
        this.diccionario = new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        Integer llave = contador;
        diccionario.put(llave, listaDePrendas);
        contador++;
        return llave;
    }

    public void mostrarPrendas(){
        for (Integer llave: diccionario.keySet()){
            List<Prenda> listaDePrendas = diccionario.get(llave);
            System.out.println("Llave: " + llave + "\nPrendas: ");
            listaDePrendas.stream().forEach(prenda -> System.out.println(prenda.toString() + "\n"));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> listaDePrendas = diccionario.get(numero);
        return listaDePrendas;
    }
}
