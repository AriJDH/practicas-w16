package ejerciciosIntegradoresP2Vivo.SaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> diccionarioPrendas;
    private static Integer contador=0;

    public GuardaRopa() {
        this.contador = ++contador;
        diccionarioPrendas = new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getDiccionarioPrendas() {
        return diccionarioPrendas;
    }

    public void setDiccionarioPrendas(Map<Integer, List<Prenda>> diccionarioPrendas) {
        this.diccionarioPrendas = diccionarioPrendas;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.diccionarioPrendas.put(contador,listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        this.diccionarioPrendas.forEach((k,v)-> System.out.println("Numero: "+ k + " Prendas: " + v));
    }

    public List<Prenda> devolverPrenda(Integer numero){
        return this.diccionarioPrendas.get(numero);
    }
}
