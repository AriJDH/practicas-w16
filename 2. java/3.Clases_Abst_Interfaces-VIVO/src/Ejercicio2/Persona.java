package Ejercicio2;

public class Persona implements IDocumento {
    private String name;
    private String lastName;
    private String dni;

    public Persona(String name, String lastName, String dni) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }

    @Override
    public String toString(){
        return  "-- Nombre: " + name + " \n" +
                "-- Apellido: " + lastName + " \n" +
                "-- DNI: " + dni;
    }
}
