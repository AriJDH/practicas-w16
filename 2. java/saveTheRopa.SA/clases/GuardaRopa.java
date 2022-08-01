package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class GuardaRopa {

   private int id;
   private HashMap<Integer, ArrayList<Prenda>> guardaRopa;

   public GuardaRopa() {
      this.id = 0;
      this.guardaRopa = new HashMap<>();
   }

   public int getContador() {
      return id;
   }

   public HashMap<Integer, ArrayList<Prenda>> getGuardaRopa() {
      return guardaRopa;
   }

   public void setGuardaRopa(HashMap<Integer, ArrayList<Prenda>> guardaRopa) {
      this.guardaRopa = guardaRopa;
   }

   public void setContador(int id) {
      this.id = id;
   }

   public Integer guardarPrendas(ArrayList<Prenda> listaDePrenda) {
      this.id += 1;
      this.guardaRopa.put(id, listaDePrenda);
      return id;
   }

   public void mostrarPrendas(){
      for(Integer key : guardaRopa.keySet()){
         System.out.println(guardaRopa.get(key));
      }
   }

   public ArrayList<Prenda> devolverPrendas(Integer id){
      return guardaRopa.get(id);
   }

}
