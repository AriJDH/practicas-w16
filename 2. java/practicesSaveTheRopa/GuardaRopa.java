package practicesSaveTheRopa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int countId;
    private Map<Integer, List<Prenda>> dataGuardaRopa;

    public GuardaRopa(int countId, Map<Integer, List<Prenda>> dataGuardaRopa) {
        this.countId = countId;
        this.dataGuardaRopa = dataGuardaRopa;
    }

    public GuardaRopa() {
    }

    public int getCountId() {
        return countId;
    }

    public void setCountId(int countId) {
        this.countId = countId;
    }

    public Map<Integer, List<Prenda>> getDataGuardaRopa() {
        return dataGuardaRopa;
    }

    public void setDataGuardaRopa(Map<Integer, List<Prenda>> dataGuardaRopa) {
        this.dataGuardaRopa = dataGuardaRopa;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "countId=" + countId +
                ", dataGuardaRopa=" + dataGuardaRopa +
                '}';
    }

    public int guardarPrendas(List<Prenda> listPrendas) {

        dataGuardaRopa.put(++countId, listPrendas);
        return countId;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry: dataGuardaRopa.entrySet()) {
            System.out.println("Id: " + entry.getKey() + "-" + entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {

        List<Prenda> prendas = new ArrayList<>();
        for (Map.Entry<Integer, List<Prenda>> entry: dataGuardaRopa.entrySet()) {
            if (entry.getKey().equals(numero)) {
                prendas = entry.getValue();
            }
        }
        return prendas;
    }

}
