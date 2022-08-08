package generics_wrapper.ejercicio_1y2;

import java.util.List;

public class Garaje {
    private Long id;
    private List<Vehiculo> vehiculoList;

    public Garaje() {
    }

    public Garaje(Long id, List<Vehiculo> vehiculoList) {
        this.id = id;
        this.vehiculoList = vehiculoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    public double calculateAverage() {
        return this.vehiculoList.stream()
                .mapToDouble(v -> v.getCosto())
                .average()
                .orElse(0.0);
    }
}
