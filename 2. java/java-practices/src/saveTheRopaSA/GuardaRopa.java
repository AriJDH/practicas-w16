package saveTheRopaSA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private Integer contador;

    public GuardaRopa() {
        this.prendas = new HashMap();
        this.contador = 0;
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return this.prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        this.contador++;
        this.prendas.put(this.contador, listaDePrendas);

        return this.contador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : this.prendas.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            System.out.println(entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return this.prendas.get(numero);
    }
}
