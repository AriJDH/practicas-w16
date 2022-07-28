package ejercicioDos.documentos;

import ejercicioDos.interfaces.Imprimible;

import java.util.List;

public class Curriculum implements Imprimible{
    private String nombre;
    private String dni;
    private String numero;
    private String correo;
    private List<String> habilidades;

    public Curriculum() {
    }

    public Curriculum(String nombre, String dni, String numero, String correo, List<String> habilidades) {
        this.nombre = nombre;
        this.dni = dni;
        this.numero = numero;
        this.correo = correo;
        this.habilidades = habilidades;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", numero='" + numero + '\'' +
                ", correo='" + correo + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }
}
