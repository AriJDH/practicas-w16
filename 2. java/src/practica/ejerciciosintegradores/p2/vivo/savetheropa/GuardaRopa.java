package practica.ejerciciosintegradores.p2.vivo.savetheropa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    public static GuardaRopa guardaRopa = null;
    protected HashMap<Integer, List<Prenda>> prendas = new HashMap<>();
    protected int id = 1;

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        this.getPrendas().put(this.getId(), listaDePrendas);
        return this.incrementarId();
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        if (this.getPrendas() == null) {
            return new ArrayList<>();
        }
        return this.getPrendas().get(numero);
    }

    protected int incrementarId() {
        int id = this.getId();
        this.setId(id + 1);
        return id;
    }

    public GuardaRopa() {}

    public GuardaRopa(HashMap<Integer, List<Prenda>> prendas, int id) {
        this.prendas = prendas;
        this.id = id;
    }

    public HashMap<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(HashMap<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
