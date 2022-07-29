package clases_abs_int.impresion.models;

import clases_abs_int.impresion.interfaces.IImprimir;

import java.util.List;

public class Curriculum implements IImprimir {
    private String nombre;
    private String apellido;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("IMPRIMIENDO CURRICULUM:");
        System.out.printf("Nombre: %s, %s.\n", this.apellido, this.nombre);
        if(this.habilidades.size() == 0) System.out.println("No tiene habilidades.");
        else {
            System.out.println("Habilidades:");
            for (String habilidad : this.habilidades) System.out.printf("\t-%s.\n", habilidad);
        }
        System.out.println();
    }
}
