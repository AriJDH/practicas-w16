public class Vehiculo {
    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;

    public Vehiculo() {
    }

    public Vehiculo(Double unaVelocidad,
                    Double unaAceleracion,
                    Double unAnguloDeGiro,
                    String unaPatente,
                    Double unPeso,
                    Integer ruedas){
        this.velocidad = unaVelocidad;
        this.aceleracion = unaAceleracion;
        this.anguloDeGiro = unAnguloDeGiro;
        this.patente = unaPatente;
        this.peso = unPeso;
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public void setAceleracion(Double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public void setAnguloDeGiro(Double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public Double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }

    @Override
    public int hashCode() {
        return patente.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vehiculo)){
            return false;
        }

        Vehiculo otroVehiculo = (Vehiculo) obj;

        return otroVehiculo.getPatente().equals(this.patente);
    }
}
