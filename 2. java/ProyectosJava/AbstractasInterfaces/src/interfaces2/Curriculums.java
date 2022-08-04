package abstractasInterfases.interfaces2;

import java.util.List;

public class Curriculums implements Imprimible{

    String nombre;
    String dni;
    String correo;
    List habilidades;

    public Curriculums(String nombre, String dni, String correo, List habilidades) {
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculums{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", correo='" + correo + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());

    }
}
