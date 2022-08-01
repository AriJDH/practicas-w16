package SaveTheRopa;

public  class Prenda {
    private String Marca;
    private String Model;

    public Prenda() {
    }

    public Prenda(String marca, String model) {
        Marca = marca;
        Model = model;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "Marca='" + Marca + '\'' +
                ", Model='" + Model + '\'' +
                '}';
    }
}
