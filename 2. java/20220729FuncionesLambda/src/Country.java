public class Country {

    private String nombre;
    private String continente;

    public Country(String nombre, String continente) {
        this.nombre = nombre;
        this.continente = continente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    @Override
    public String toString() {
        return "Country{" +
                "nombre='" + nombre + '\'' +
                ", continente='" + continente + '\'' +
                '}';
    }
}
