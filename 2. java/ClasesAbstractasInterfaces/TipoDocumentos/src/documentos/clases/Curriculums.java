package documentos.clases;

import documentos.interfaces.Imprimible;

import java.util.ArrayList;
import java.util.List;

public class Curriculums implements Imprimible {
    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;
    private String profesion;
    private List<String> habilidades;

    public Curriculums(String nombre, String apellido, int edad, String estadoCivil, String profesion, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
        this.profesion = profesion;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir(String documento) {
        System.out.println("-----------------------");
        System.out.println(documento);
        System.out.println("Nombre : "+this.nombre);
        System.out.println("Apellido: "+this.apellido);
        System.out.println("Edad: "+ this.edad);
        System.out.println("Estado Civil: " +this.estadoCivil);
        System.out.println("Profesión: "+this.profesion);
        System.out.println("Habilidades: "+this.habilidades);
    }
}
