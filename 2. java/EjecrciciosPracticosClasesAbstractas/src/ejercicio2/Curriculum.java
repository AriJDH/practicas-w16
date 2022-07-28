package ejercicio2;

import java.util.List;

public class Curriculum implements Imprimible {
    private String nombre;
    private String dni;
    private String correro;
    List<String> Habiliades;

    public Curriculum(String nombre, String dni, String correro, List<String> habiliades) {
        this.nombre = nombre;
        this.dni = dni;
        this.correro = correro;
        Habiliades = habiliades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", correro='" + correro + '\'' +
                ", Habiliades=" + Habiliades +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorrero() {
        return correro;
    }

    public void setCorrero(String correro) {
        this.correro = correro;
    }

    public List<String> getHabiliades() {
        return Habiliades;
    }

    public void setHabiliades(List<String> habiliades) {
        Habiliades = habiliades;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }
}
