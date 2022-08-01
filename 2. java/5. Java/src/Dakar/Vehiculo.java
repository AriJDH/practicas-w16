package Dakar;

public class Vehiculo {
    private Integer Velocidad;
    private Integer Aceleracion;
    private Double AnguloDeGiro;
    private String Patente;
    private Integer Peso;
    private Integer Rueda;
    private eCategoria Categoria;

    public Vehiculo(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente, Integer peso, Integer rueda, eCategoria categoria) {
        Velocidad = velocidad;
        Aceleracion = aceleracion;
        AnguloDeGiro = anguloDeGiro;
        Patente = patente;
        Peso = peso;
        Rueda = rueda;
        Categoria = categoria;
    }

    public Vehiculo(String patente) {
        Patente = patente;
    }

    public Integer getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        Velocidad = velocidad;
    }

    public Integer getAceleracion() {
        return Aceleracion;
    }

    public void setAceleracion(Integer aceleracion) {
        Aceleracion = aceleracion;
    }

    public Double getAnguloDeGiro() {
        return AnguloDeGiro;
    }

    public void setAnguloDeGiro(Double anguloDeGiro) {
        AnguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String patente) {
        Patente = patente;
    }

    public Integer getPeso() {
        return Peso;
    }

    public void setPeso(Integer peso) {
        Peso = peso;
    }

    public Integer getRueda() {
        return Rueda;
    }

    public void setRueda(Integer rueda) {
        Rueda = rueda;
    }

    public eCategoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(eCategoria categoria) {
        Categoria = categoria;
    }


    @Override
    public String toString() {
        return "Vehiculo{" +
                "Velocidad=" + Velocidad +
                ", Aceleracion=" + Aceleracion +
                ", AnguloDeGiro=" + AnguloDeGiro +
                ", Patente='" + Patente + '\'' +
                ", Peso=" + Peso +
                ", Rueda=" + Rueda +
                ", Categoria=" + Categoria.toString() +
                '}';
    }
}
