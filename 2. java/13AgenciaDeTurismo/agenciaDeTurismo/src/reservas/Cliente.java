package reservas;

import java.util.List;

public class Cliente {
    private String nombre;
    private String dni;
    //private List<String> Localizador;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }



    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
