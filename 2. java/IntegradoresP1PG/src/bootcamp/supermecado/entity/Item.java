package bootcamp.supermecado.entity;

public class Item {
    private Integer codigo;
    private String nombre;
    private Integer cantidadComprada;
    private Double CosotUnitario;

    public Item(){}

    public Item(Integer codigo, String nombre, Integer cantidadComprada, Double cosotUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        CosotUnitario = cosotUnitario;
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

    public Double getCosotUnitario() {
        return CosotUnitario;
    }

    public void setCosotUnitario(Double cosotUnitario) {
        CosotUnitario = cosotUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                ", CosotUnitario=" + CosotUnitario +
                '}';
    }
}
