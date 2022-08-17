public class Item {
    private int codigo;
    private String nombreProducto;
    private String cantidadComprada;
    private double costoUnitario;

    public Item(int codigo, String nombreProducto, String cantidadComprada, double costoUnitario) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(String cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", cantidadComprada='" + cantidadComprada + '\'' +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
