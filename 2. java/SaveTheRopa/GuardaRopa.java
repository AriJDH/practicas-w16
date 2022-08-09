package SaveTheRopa;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa implements IRepositorio {

    private HashMap<Integer, List<Prenda>> prendas;
    private Integer id;
    GuardaRopa() {
        this.prendas = new HashMap<Integer, List<Prenda>>();
        this.id = 0;
    }
    @Override
    public Integer guardar(List<Prenda> prenda) {
        this.prendas.put(id++, prenda);
        return id;
    }

    @Override
    public List<Prenda> devolverPrenda(Integer id) {
        return this.prendas.get(id);
    }

    @Override
    public void mostrarPrendas() {
        this.prendas.forEach((integer, prenda) -> {
            System.out.println("id " + prenda.toString());
        });
    }
}
