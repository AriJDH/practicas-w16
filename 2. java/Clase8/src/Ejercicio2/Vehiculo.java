package Ejercicio2;

public abstract class Vehiculo  {
    protected Integer velocidad;
    protected Float aceleracion;
    protected Float anguloDeGiro;
    protected String patente;
    protected Float peso;
    protected Integer ruedas;

    public Vehiculo(){

    }

    public Vehiculo(Integer velocidad, Float aceleracion, Float anguloDeGiro, String patente, Float peso, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
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

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Float getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Float aceleracion) {
        this.aceleracion = aceleracion;
    }

    public Float getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(Float anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }
}
