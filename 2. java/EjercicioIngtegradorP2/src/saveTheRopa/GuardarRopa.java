package saveTheRopa;

import java.util.*;

public class GuardarRopa {
    Map<Integer, List<Prenda>> diccionario = new HashMap<Integer,List<Prenda>>();

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    @Override
    public String toString() {
        return "GuardarRopa{" +
                "diccionario=" + diccionario +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        Integer numero;
        if(!diccionario.isEmpty()){
            numero = diccionario.size()+1;
            this.diccionario.put(numero,listaDePrenda);
        }else {
            numero = 1;
            this.diccionario.put(numero, listaDePrenda);
        }
        return numero;
    }



    public void mostrarPrendas(){
        Iterator it  = diccionario.keySet().iterator();
        while (it.hasNext()){
            Integer key = (Integer) it.next();
            System.out.println("Casillero: "+key+" Prendas: "+ diccionario.get(key));
        }

    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> prendasDevolver = new ArrayList<>();
        prendasDevolver=diccionario.get(numero);
        return prendasDevolver;
    }
}
