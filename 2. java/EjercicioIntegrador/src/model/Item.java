package model;

public class Item {
    private String nombre;
    private Long codigo;
    private double costoUnitario;
    private int cantidad;

    public Item() {
    }

    public Item(String nombre, Long codigo, double costoUnitario, int cantidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.costoUnitario = costoUnitario;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
