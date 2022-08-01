public class Hotel {
    private String nombre;
    private double costo;

    public Hotel(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Hotel: " +
                "nombre='" + nombre + '\'' +
                ", costo=" + costo +
                '}';
    }
}
