package JavaEjercicioIntegradoP2PG;

import java.util.List;

public class Facturas {
    private Cliente cliente;
    private List<Item> items;
    private int totalCompra;

    public Facturas() {
    }

    public Facturas(Cliente cliente, List<Item> items, int totalCompra) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
    }
}
