package ClasesAbstractas_Interfaces.Ejercicio2;

import java.util.List;

public class Curriculum implements Imprimible{

    private String nombre;
    private String apellido;
    private int edad;
    private String mail;
    private String telefono;
    private List<String> habilidades;

    public Curriculum() {}

    public Curriculum(String nombre, String apellido, int edad, String mail, String telefono, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.mail = mail;
        this.telefono = telefono;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", mail='" + mail + '\'' +
                ", telefono='" + telefono + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

}
