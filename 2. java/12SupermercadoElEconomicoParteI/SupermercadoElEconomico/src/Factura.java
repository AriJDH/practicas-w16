import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int codigoFactura;
    private Cliente cliente;
    List<Item> listaItemsComprados;
    private double montoTotalFacturado;

    public Factura() {
        this.listaItemsComprados = new ArrayList<>();
    }

    public Factura(int codigoFactura, Cliente cliente, List<Item> listaItemsComprados, double montoTotalFacturado) {
        this.codigoFactura = codigoFactura;
        this.cliente = cliente;
        this.listaItemsComprados = listaItemsComprados;
        this.montoTotalFacturado = montoTotalFacturado;
    }

    public double getMontoTotalFacturado() {
        return montoTotalFacturado;
    }

    public void setMontoTotalFacturado(double montoTotalFacturado) {
        this.montoTotalFacturado = montoTotalFacturado;
    }

    public List<Item> getListaItemsComprados() {
        return listaItemsComprados;
    }

    public void setListaItemsComprados(List<Item> listaItemsComprados) {
        this.listaItemsComprados = listaItemsComprados;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigoFactura=" + codigoFactura +
                ", cliente=" + cliente +
                ", listaItemsComprados=" + listaItemsComprados +
                ", montoTotalFacturado=" + montoTotalFacturado +
                '}';
    }
}
