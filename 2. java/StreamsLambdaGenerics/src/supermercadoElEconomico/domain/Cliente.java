package supermercadoElEconomico.domain;

public class Cliente {
    private String dni;
    private String nombre;
    private String Apellido;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        Apellido = apellido;
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
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    @Override
    public String toString() {
        return
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", Apellido='" + Apellido;
    }
}
