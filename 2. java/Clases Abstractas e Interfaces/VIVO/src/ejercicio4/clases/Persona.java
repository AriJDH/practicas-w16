package ejercicio4.clases;

public abstract class Persona {
    private String nombre;
    private int edad;

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona() {
    }
}
