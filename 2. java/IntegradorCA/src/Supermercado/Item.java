package Supermercado;

public class Item {
    private Integer codigo;
    private String nombre;
    private Integer cantidadComprada;
    private Double costoUnit;

    public Item(Integer codigo, String nombre, Double costoUnit) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costoUnit = costoUnit;
    }

    public Item(Integer codigo, String nombre, Integer cantidadComprada, Double costoUnit) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnit = costoUnit;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(Integer cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public Double getCostoUnit() {
        return costoUnit;
    }

    public void setCostoUnit(Double costoUnit) {
        this.costoUnit = costoUnit;
    }

    @Override
    public String toString() {
        return "Item:" +
                "Código = " + codigo +
                ", Nombre = '" + nombre + '\'' +
                ", Cant. Comprada =" + cantidadComprada +
                ", Costo Unidad = " + costoUnit +
                '.';
    }
}
