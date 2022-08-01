package saveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

   private int contador = 1 ;
   private Map<Integer, List<Prenda>> prendasGuardadas = new HashMap<>();

   public Integer guardarPrendas(List<Prenda> prendas){
       prendasGuardadas.put(contador,prendas);
       int temp = contador;
       contador++;
       return temp;
   }

   public void mostrarPrendas(){
        prendasGuardadas
                .forEach((k,v) ->{
                    System.out.println("numero: "+ k + " prendas: "+v);
                });
   }

   public List<Prenda> devolverPrendas(int numero){
        return prendasGuardadas.get(numero);
   }
}
