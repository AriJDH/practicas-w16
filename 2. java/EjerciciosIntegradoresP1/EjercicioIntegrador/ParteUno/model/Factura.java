package EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.model;

import java.util.List;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(){
        
    }

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<Item>();
        this.total = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;

        for (Item item : items) {
            this.total += item.getPrecio() * item.getCantidad();
        }
    }

    public void addItem(Item item) {
        this.items.add(item);
        total += item.getPrecio() * item.getCantidad();
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                '}';
    }

    public String getFactura() {
        String factura = "";
        factura += "Factura de " + cliente.getNombre() + " " + cliente.getApellido() + "\n";
        for (Item item : items) {
            factura += item.getNombre() + " " + item.getCodigo() + " " + item.getCantidad() + " " + item.getPrecio() + "\n";
        }
        factura += "Total: " + getTotal();
        return factura;
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
