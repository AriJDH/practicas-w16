package EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.model;

import java.lang.reflect.Field;

public class Item {
    private String nombre;
    private String codigo;
    private int cantidad;
    private double precio;

    public Item(String nombre, String codigo, int cantidad, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }

    public String get(String attr){
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().equals(attr)) {
                try {
                    return field.get(this).toString();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
    
}
