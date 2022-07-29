package imprimir.modelos;

import imprimir.interfaces.Documento;

import java.util.List;

public class Curriculum implements Documento {

    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String profesion;
    private String correo;
    private List<String> habilidades;

    public Curriculum(){}

    public Curriculum(String dni, String nombre, String apellido, int edad, String profesion, String correo, List<String> habilidades) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.profesion = profesion;
        this.correo = correo;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum \n"+ "- DNI: "+ dni+ "\n"+ "-Nombre: "+nombre+ "\n-Apellido: " + apellido + "\n-Edad: " +edad+ "\n-Profesion: "+profesion+ "\n-Correo: "+correo+ "\n-Habilidades: " + habilidades.toString();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
