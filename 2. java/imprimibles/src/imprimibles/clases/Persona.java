package imprimibles.clases;

public class Persona {
    private String datos;

    public Persona(String datos) {
        this.datos = datos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "datos='" + datos + '\'' +
                '}';
    }
}
