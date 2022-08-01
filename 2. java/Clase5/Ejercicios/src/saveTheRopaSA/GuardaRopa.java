package saveTheRopaSA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private Integer contador;

    public GuardaRopa(){
        this.prendas = new HashMap();
        this.contador = 0;
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer guardarPrendas(List<Prenda> prendas){
        this.contador++;
        this.prendas.put(this.contador, prendas);

        return this.contador;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer,List<Prenda>> entrada: this.prendas.entrySet()){
            System.out.print(entrada.getKey() + ": ");
            System.out.println(entrada.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer identificador){
        return this.prendas.get(identificador);
    }
}
