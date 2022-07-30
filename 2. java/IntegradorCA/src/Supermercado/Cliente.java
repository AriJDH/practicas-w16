package Supermercado;

public class Cliente {
    private Integer dni;
    private String nombre;
    private String apellido;

    public Cliente(Integer dni) {
        this.dni = dni;
    }

    public Cliente(Integer dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Cliente(Integer dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y Setters
    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
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

    // toString

    @Override
    public String toString() {
        return "Cliente:" +
                "DNI = " + dni +
                ", Nombre = '" + nombre + '\'' +
                ", Apellido = '" + apellido + '\'' +
                '.';
    }
}
