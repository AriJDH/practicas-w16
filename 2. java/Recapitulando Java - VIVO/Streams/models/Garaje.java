package Streams.models;

import java.util.LinkedList;
import java.util.List;

public class Garaje {

    private Long id;

    private List<Vehiculo> autos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Vehiculo> getAutos() {
        return autos;
    }

    public void setAutos(List<Vehiculo> autos) {
        this.autos = autos;
    }

    public Garaje() {
    }

    public Garaje(Long id, List<Vehiculo> autos) {
        this.id = id;
        this.autos = autos;
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", autos=" + autos +
                '}';
    }
}
