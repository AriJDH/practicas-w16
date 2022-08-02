package integrador.supermercado.models;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;

    public Cliente(){}

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
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

    @Override
    public String toString() {
        return String.format("Cliente:\n\t-Nombre y apellido: %s %s.\n\t-DNI: %s.", this.nombre, this.apellido, this.dni);
    }
}
