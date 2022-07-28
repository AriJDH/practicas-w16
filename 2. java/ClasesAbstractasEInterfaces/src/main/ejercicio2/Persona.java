package main.ejercicio2;

public class Persona {
    private  String nombre;
    private  String apellido;
    private  String dni;
    private  int edad;

    public Persona(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }
   @Override
    public String toString() {
        return "Persona{" +
                "nombre = " + nombre +
                "apellido = " + nombre +
                ", dni = " + dni +
                ", edad = " + edad +
                "}";
    }

}
