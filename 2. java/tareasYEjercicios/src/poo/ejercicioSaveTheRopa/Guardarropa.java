package poo.ejercicioSaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardarropa {

    private Map<Integer, List<Prenda>> mapPrendas = new HashMap<>();
    private Integer contadorDeIds = 0;

    public Guardarropa() {
    }

    public Map<Integer, List<Prenda>> getMapPrendas() {
        return mapPrendas;
    }

    public void setMapPrendas(Map<Integer, List<Prenda>> mapPrendas) {
        this.mapPrendas = mapPrendas;
    }

    public Integer getContadorDeIds() {
        return contadorDeIds;
    }

    public void setContadorDeIds(Integer contadorDeIds) {
        this.contadorDeIds = contadorDeIds;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contadorDeIds++;
        this.mapPrendas.put(contadorDeIds, listaDePrenda);
        return contadorDeIds;
    }

    public void mostrarPrendas() {
        mapPrendas.entrySet().forEach(entry -> {
            System.out.println("Id " + entry.getKey() + " \n " + entry.getValue());
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return this.mapPrendas.remove(numero);
    }

    public List<Prenda> consultarPrendas(Integer numero) {
        return this.mapPrendas.get(numero);
    }

    @Override
    public String toString() {
        return "\nGuardarropa " +
                "lista de prendas:" + mapPrendas +
                ", id:" + contadorDeIds;
    }
}
