package documentos;

import interfaces.Imprimible;

import java.util.List;

public class Curriculums implements Imprimible {

    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private List<String> habilidades;

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public Curriculums(String nombre, String apellido, String dni, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public void realizarImpresion() {
        System.out.println("CURRICULUM");
        System.out.println("----------");

        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.nombre);
        System.out.println("Dni: " + this.nombre);
        System.out.println("Edad: " + this.edad);

        System.out.println("Habilidades");
        for (int i=0;i<this.habilidades.size();i++){
            System.out.println(this.habilidades.get(i));
        }

    }
}
