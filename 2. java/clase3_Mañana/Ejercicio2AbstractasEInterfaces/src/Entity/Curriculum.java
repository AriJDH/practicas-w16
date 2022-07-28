package Entity;

import Interface.Imprimible;

import java.util.List;

public class Curriculum extends Documento implements Imprimible {
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;

    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, int edad, String celular, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.habilidades = habilidades;
    }


    @Override
    public void imprimir() {
        System.out.println("Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", habilidades=" + habilidades +
                '}');
    }
}
