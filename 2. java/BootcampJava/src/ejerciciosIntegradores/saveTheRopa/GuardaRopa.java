package ejerciciosIntegradores.saveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    protected Integer contador = 0;
    protected Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "contador=" + contador +
                ", prendas=" + prendas +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador++;
        prendas.put(contador,listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        System.out.println(prendas.toString());
        System.out.println("------");
        prendas.forEach((c,p)-> System.out.println("Contador: " + c + " " + p.toString()));
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }



}

