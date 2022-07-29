package supermercadoElEconomico.domain;

public class Item {
    private int codigo;
    private String nombre;
    private int cantidad;
    private double costounitario;

    public Item(int codigo, String nombre, int cantidad, double costounitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costounitario = costounitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostounitario() {
        return costounitario;
    }

    public void setCostounitario(double costounitario) {
        this.costounitario = costounitario;
    }
}
