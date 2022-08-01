public  class Prenda {
    private String modelo;
    private String marca;


    public Prenda(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
