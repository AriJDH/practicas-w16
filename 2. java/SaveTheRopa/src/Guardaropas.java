import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardaropas {
    private int id = 0;
    private Map<Integer, List<Prenda>> prendasGuardadas  = new HashMap<>();

    public Guardaropas() {
    }

    public Guardaropas(int id, Map<Integer, List<Prenda>> prendasGuardadas) {
        this.id = id;
        this.prendasGuardadas = prendasGuardadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, List<Prenda>> getPrendasGuardadas() {
        return prendasGuardadas;
    }

    public void setPrendasGuardadas(Map<Integer, List<Prenda>> prendasGuardadas) {
        this.prendasGuardadas = prendasGuardadas;
    }

    public Integer guardarPrendas(List<Prenda> lista){
        id = id + 1;
        prendasGuardadas.put(id,lista);
        return id;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> elem : prendasGuardadas.entrySet()){
            Integer id = elem.getKey();
            System.out.println("Id: " + id);
            List<Prenda> listaDePrendaId = elem.getValue();
            System.out.println("Prendas: " + listaDePrendaId.toString() + '\'');
        }
      //  prendasGuardadas.forEach((id, listaDePrendas) ->  System.out.println("Id: " + id.getKey() + "Prendas: " + listaDePrendas + '\''));
    }

    public List<Prenda> devolverPrendas(Integer id){
        return prendasGuardadas.get(id);
    }
}
