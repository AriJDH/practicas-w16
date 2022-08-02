package poo.ejercicioDakar;

public abstract class Vehiculo {

    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    protected Double peso;
    protected double ruedas;

    public Vehiculo(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso, double ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public Double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(Double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public double getRuedas() {
        return ruedas;
    }

    public void setRuedas(double ruedas) {
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "\n" +
                "velocidad: " + velocidad +
                ", aceleracion: " + aceleracion +
                ", anguloDeGiro: " + anguloDeGiro +
                ", patente: " + patente +
                ", peso: " + peso +
                ", ruedas: " + ruedas +
                '}';
    }

}
