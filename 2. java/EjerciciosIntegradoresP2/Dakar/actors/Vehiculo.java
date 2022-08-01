package EjerciciosIntegradoresP2.Dakar.actors;

public abstract class Vehiculo {
    protected double aceleracion;
    protected double velocidad;
    protected double anguloDeGiro;
    protected String patente;
    protected double peso;
    protected int cantidadDeRuedas;

    public Vehiculo(double aceleracion, double velocidad, double anguloDeGiro, String patente, double peso, int cantidadDeRuedas) {
        this.aceleracion = aceleracion;
        this.velocidad = velocidad;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.cantidadDeRuedas = cantidadDeRuedas;
    }


    public double getAceleracion() {
        return this.aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
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

    public int getCantidadDeRuedas() {
        return this.cantidadDeRuedas;
    }

    public void setCantidadDeRuedas(int cantidadDeRuedas) {
        this.cantidadDeRuedas = cantidadDeRuedas;
    }

    public double getScore(){
        return velocidad * 0.5 * aceleracion / (anguloDeGiro*(peso - cantidadDeRuedas * 100));
    }

}
