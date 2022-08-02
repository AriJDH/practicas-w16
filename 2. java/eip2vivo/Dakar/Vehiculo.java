package eip2vivo.Dakar;

public class Vehiculo {
    private Integer velocidad;
    private Integer aceleracion;
    private double anguloDeGiro;
    private String patente;
    private double peso;
    private Integer ruedas;

    public Integer getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getAceleracion() {
        return this.aceleracion;
    }

    public void setAceleracion(Integer aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAnguloDeGiro() {
        return this.anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return this.patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Integer getRuedas() {
        return this.ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }

    public Vehiculo(Integer velocidad, Integer aceleracion, double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
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
}
