package AgenciaTurismo;

public class Producto implements IProducto {
    private String name;
    @Override
    public String getNombre() {
        return name;
    }
    @Override
    public void setNombre(String name) {
        this.name = name;
    }
    public Producto(String name) {
        this.name = name;
    }
}
