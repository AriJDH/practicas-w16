package practicaEnVivo;

import java.util.List;

public class Garaje {
    private int id = 0;
    private List<Vehiculo> lista;

    public Garaje(int id, List<Vehiculo> lista) {
        this.id = id;
        this.lista = lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getLista() {
        return lista;
    }

    public void setLista(List<Vehiculo> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", lista=" + lista +
                '}';
    }
}
