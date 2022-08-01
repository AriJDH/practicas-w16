package integradores.integrador2.dakar;

public abstract class Vehiculo {

    private int velocidad;
    private int aceleracion;
    private int anguloDeGiro;
    private String patente;

    public Vehiculo(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(int aceleracion) {
        this.aceleracion = aceleracion;
    }

    public int getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(int anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public abstract int getPeso();
    public abstract int getCantRuedas();

    public double getResultado(){
        return (this.velocidad * this.aceleracion * 0.5) / (this.anguloDeGiro * (this.getPeso() - (this.getCantRuedas() * 100)));
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "tipo= " + this.getClass().getSimpleName() +
                ", velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                '}';
    }
}
