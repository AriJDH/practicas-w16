public class BoletosViajes {
    private String descripcion;
    private double costo;

    public BoletosViajes(String descripcion, double costo) {
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
        return "BoletosViajes: \n" +
                "descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                '}';
    }
}
