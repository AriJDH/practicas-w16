package Ejercicios2;

import java.util.List;

public class Curriculums implements imprimible {
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private int edad;
    private List<String> habilidades;

    public Curriculums(String nombre, String direccion, String telefono, String email, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Direccion: " + direccion);
        System.out.println("Telefono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Edad: " + edad);
        System.out.println("Habilidades: " + habilidades);
    }
}
