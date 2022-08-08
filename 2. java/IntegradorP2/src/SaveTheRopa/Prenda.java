package SaveTheRopa;

public class Prenda {
    protected String marca;
    protected String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "{" +
                "marca = '" + marca + '\'' +
                ", modelo = '" + modelo + '\'' +
                '}';
    }
}
