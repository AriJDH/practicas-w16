package poo.ejercicioBanco;

public class Cliente {
    private String nombre;
    private String dni;
    private String cbu;

    public Cliente(String nombre, String dni, String cbu) {
        this.nombre = nombre;
        this.dni = dni;
        this.cbu = cbu;
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

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", cbu='" + cbu + '\'' +
                '}';
    }
}
