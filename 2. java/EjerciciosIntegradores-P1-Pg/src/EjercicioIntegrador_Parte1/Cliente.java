package EjercicioIntegrador_Parte1;

public class Cliente {
    private String nombre;
    private String Dni;
    private String apellido;

    public Cliente(String nombre, String dni, String apellido) {
        this.nombre = nombre;
        Dni = dni;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return Dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", Dni='" + Dni + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
