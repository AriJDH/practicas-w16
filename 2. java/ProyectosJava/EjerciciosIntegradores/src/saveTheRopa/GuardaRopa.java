package saveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    public Map<Integer, List<Prenda>> mapa = new HashMap<>();
    private int contador;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){

        contador++;
        mapa.put(contador,listaDePrenda);
        return contador;
    };

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : mapa.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Prendas = " + entry.getValue());
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return mapa.get(numero);
    }

    //  buscar una prenda
    //boolean bandera = true;

        //for (Map.Entry<Integer, List<Prenda>> entry : mapa.entrySet()){

        //if (entry.getValue().equals(listaDePrenda)){
            //bandera = false;
            //return entry.getKey();
        //}
    //}
        //if (bandera) System.out.println("No se ha encontrado la prenda");
        //return null;


    @Override
    public String toString() {
        return "GuardaRopa{" +
                "mapa=" + mapa +
                ", contador=" + contador +
                '}';
    }

    public GuardaRopa() {
        this.mapa = new HashMap<>();
        this.contador = 0;
    }
}



