import naves.Nave;

import java.util.List;

public class Participante {
    private String nombre;
    private List<Nave> flotaNave;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Nave> getFlotaNave() {
        return flotaNave;
    }

    public void setFlotaNave(List<Nave> flotaNave) {
        this.flotaNave = flotaNave;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", flotaNave=" + flotaNave +
                '}';
    }

    public Participante(String nombre, List<Nave> flotaNave) {
        this.nombre = nombre;
        this.flotaNave = flotaNave;
    }

    public Double promedioDistancia(int coordenada_meteorito_x, int coordenada_meteorito_y){
        Double sum = 0d;
        Double promedio = 0d;
        sum = flotaNave.stream()
                .mapToDouble(x -> x.calcularDistancia(coordenada_meteorito_x,coordenada_meteorito_y))
                .sum();
        promedio = sum/flotaNave.stream().count();
        return promedio;
    }
}
