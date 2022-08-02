public  class Prenda {

    protected String modelo;
    protected String marca;

    public Prenda() {
    }

    public Prenda(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Prenda\n" +
                "modelo= " + modelo + "\n" +
                ", marca= " + marca +"\n" +
                "------------------------------";
    }
}
