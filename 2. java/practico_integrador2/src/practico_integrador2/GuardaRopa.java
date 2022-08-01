package practico_integrador2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {


    private Map<Integer, List<Prenda>> diccionario;
    private int contador;


    public Integer guardarPrendas(List<Prenda> prendas) {

        contador++;
        diccionario.put(contador, prendas);
        return contador;

    }


    public GuardaRopa() {

       diccionario = new HashMap<>();

    }

    public void mostrarPrendas() {

        diccionario.forEach((id, prenda) -> System.out.println(id + "-" + prenda.toString()));

    }

    public List<Prenda> devolverPrendas(Integer numero) {

        if (diccionario.containsKey(numero)) {
            return diccionario.get(numero);

        }
        return null;
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "diccionario=" + diccionario +
                ", contador=" + contador +
                '}';
    }
}
