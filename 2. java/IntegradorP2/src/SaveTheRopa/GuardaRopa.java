package SaveTheRopa;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.abs;

public class GuardaRopa {
    private HashMap<Integer, ArrayList<Prenda>> diccionario;
    private Integer contador;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(ArrayList<Prenda> listaDePrenda) {
        this.contador++;
        this.diccionario.put(this.contador,listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        System.out.println("Prendas guardadas\n ID\t Lista De Prendas");
        /*this.diccionario.entrySet().forEach(x -> {
            System.out.println(x.getKey() + '\t' + x.getValue().toString());
        });*/
        for( Integer key : this.diccionario.keySet() ) {
            String clave = key.toString();
            String valor = this.diccionario.get(key).toString();
            System.out.println(clave + '\t' + valor);
        }
    }

    public ArrayList<Prenda> devolverPrendas(Integer numero) {
        // Devuelve la lista de prendas guardadas bajo ese numero
        // no las elimina del map?
        System.out.println("Buscando prendas guardadas en ID: " + numero);
        return this.diccionario.get(numero);
    }



}
