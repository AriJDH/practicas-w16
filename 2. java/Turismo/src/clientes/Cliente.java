package clientes;

public class Cliente {
    private int dni;
    private String nombre;

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
