package integrador;

public class Item implements IItem {
    Integer codigo;
    String nombre;
    Integer precio;

    public Item(Integer codigo, String nombre, Integer precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Item() {}
    @Override
    public Integer getCodigo() {
        return codigo;
    }
    @Override
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public Integer getPrecio() {
        return precio;
    }
    @Override
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
