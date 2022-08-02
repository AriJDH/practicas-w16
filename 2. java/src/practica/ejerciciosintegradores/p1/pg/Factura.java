package practica.ejerciciosintegradores.p1.pg;

import java.util.ArrayList;

public class Factura {
    protected Cliente cliente;
    protected ArrayList<Item> items = new ArrayList<>();

    public Factura(Cliente cliente, ArrayList<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
