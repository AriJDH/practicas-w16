package EjercicioClases;

public class PracticaDosExcepciones {
    String nombre;
    double precio;

    public PracticaDosExcepciones(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "PracticaDosExcepciones{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
