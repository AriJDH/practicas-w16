package EjercicioIntegrador;

public class Items {
    private int codigo;
    private String nombre;
    private int cantidadComprada;
    private Double costoUnitario;

    public Items(int codigo, String nombre, int cantidadComprada, Double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Items{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                ", costoUnitario=" + costoUnitario +
                '}';
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

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
}
