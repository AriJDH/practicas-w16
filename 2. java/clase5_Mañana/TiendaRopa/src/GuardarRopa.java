
import java.util.*;

public class GuardarRopa {
    private Map<Integer, List<Prenda>> ropero ;
    private int contador;

    public GuardarRopa() {
        this.contador = 1;
        this.ropero = new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getRopero() {
        return ropero;
    }

    public void setRopero(Map<Integer, List<Prenda>> ropero) {
        this.ropero = ropero;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int guardarRopa(List<Prenda> ropas){
        ropero.put(this.contador,ropas);
        int identificador = this.contador;
        this.contador+=ropas.size();
        return identificador;
        }

    public void mostrarPrendas(){
        for (Map.Entry<Integer,List<Prenda>> entrada: this.ropero.entrySet()){
            System.out.println(entrada.getKey()+": ");
            System.out.println(entrada.getValue());
        }
    }

    public List<Prenda> devolverPrendas(int numero){
        return this.ropero.get(numero);
    }


}
