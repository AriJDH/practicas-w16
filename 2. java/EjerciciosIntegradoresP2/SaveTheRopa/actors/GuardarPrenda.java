package EjerciciosIntegradoresP2.SaveTheRopa.actors;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class GuardarPrenda {
    private Map<Integer, List<Prenda>> prendas;
    private Integer id;

    public GuardarPrenda() {
        this.prendas = new HashMap<Integer, List<Prenda>>();
        this.id = 0;
    }

    public Integer guardarPrenda(List<Prenda> prendas) {
        this.prendas.put(id, prendas);

        return id++;
    }

    public List<Prenda> devolverPrendas(Integer id) {
        return this.prendas.get(id);
    }

    public Map<Integer,List<Prenda>> getPrendas() {
        return this.prendas;
    }

    public void setPrendas(HashMap<Integer,List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer getId() {
        return this.id;
    }

}
