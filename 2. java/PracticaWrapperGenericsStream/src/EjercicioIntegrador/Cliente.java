package EjercicioIntegrador;

public class Cliente {
    private String ci;
    private String nombre;
    private String apellido;

    public Cliente(String ci, String nombre, String apellido) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
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
        return "Cliente{" +
                "ci='" + ci + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
