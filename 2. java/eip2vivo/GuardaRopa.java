package eip2vivo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas = new HashMap<>();
    private Integer contador = 0;

    public GuardaRopa() { }


    public Integer guardarPrendas(List<Prenda> listaDePrenda) {

        Integer key = this.contador;
        this.prendas.put(key, listaDePrenda);
        this.contador++;
        return key;

    }

    public void mostrarPrendas(){
        for (Integer key: prendas.keySet()){
            List<Prenda> listaDePrendas = prendas.get(key);
            System.out.println(listaDePrendas);
        }
    }


    public List<Prenda> devolverPrendas(Integer numero) {

        List<Prenda> prendasDevueltas = this.prendas.remove(numero);
        return prendasDevueltas;
    }
}
