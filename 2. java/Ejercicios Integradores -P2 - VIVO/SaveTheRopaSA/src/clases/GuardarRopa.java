package clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {
    private Map<Integer, List<Prenda>> mapaPrendas = new HashMap<>();
    private Integer identificador = 0;

    public Map<Integer, List<Prenda>> getMapaPrendas() {
        return mapaPrendas;
    }

    public void setMapaPrendas(Map<Integer, List<Prenda>> mapaPrendas) {
        this.mapaPrendas = mapaPrendas;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public GuardarRopa() {
    }

    public GuardarRopa(Map<Integer, List<Prenda>> mapaPrendas, Integer identificador) {
        this.mapaPrendas = mapaPrendas;
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "GuardarRopa{" +
                "mapaPrendas=" + mapaPrendas +
                ", identificador=" + identificador +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listPrenda){
        mapaPrendas.put(++identificador,listPrenda);
        return identificador;
    }


    public void mostrarPrendas(){
        mapaPrendas.forEach((key, value) -> {
            System.out.println("Identificador: " + key + "\nPrendas: " + value + " ");
        });
    }

    public List<Prenda> devolverPrenda(Integer numero){
        return mapaPrendas.get(numero);
    }


}
