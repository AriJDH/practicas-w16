package absandint.ejercicio2;

import java.util.ArrayList;

public class Curriculum implements Documento{

    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, String apellido, String dni, int edad, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
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

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void print() {
        String toPrint = "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nDNI: "
                + this.dni + "\nEdad: " + this.edad + "\nHabilidades:\n";

        for (String habilidad : this.habilidades)
            toPrint += " - " + habilidad + "\n";

        System.out.println(toPrint);
    }
}
