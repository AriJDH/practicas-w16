public class Transporte {
    private String descripcion;
    private double costo;

    public Transporte(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Transporte: \n" +
                "descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                '}';
    }
}
