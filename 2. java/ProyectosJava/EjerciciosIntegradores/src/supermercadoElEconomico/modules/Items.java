package supermercadoElEconomico.modules;

public class Items {

    private long codigo;
    private String nombre;
    private int catindadComprada;
    private double costoUnitario;

    public Items(long codigo, String nombre, int catindadComprada, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.catindadComprada = catindadComprada;
        this.costoUnitario = costoUnitario;
    }

    public Items() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCatindadComprada() {
        return catindadComprada;
    }

    public void setCatindadComprada(int catindadComprada) {
        this.catindadComprada = catindadComprada;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Items{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", catindadComprada=" + catindadComprada +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
