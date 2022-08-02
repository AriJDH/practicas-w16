public  abstract class Vehiculo {

    private int velocidad;
    private int aceleración;
    private int anguloDeGiro;
    private String patente;
    private int peso;
    private int ruedas;


    public Vehiculo() {
    }

    public Vehiculo(int velocidad, int aceleración, int anguloDeGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleración = aceleración;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAceleración() {
        return aceleración;
    }

    public void setAceleración(int aceleración) {
        this.aceleración = aceleración;
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

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }
}
