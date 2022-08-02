package integrador.supermercado.models;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Integer id;
    private Cliente cliente;
    private List<DetalleFactura> detalleFactura;
    private Double total;

    public Factura() {
        this.total = 0d;
        this.detalleFactura = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetalleFactura() {
        return detalleFactura;
    }

    public void agregarDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura.add(detalleFactura);
    }

    public Double calcularTotal(){
        return this.detalleFactura.stream()
                .mapToDouble(DetalleFactura::getTotal)
                .sum();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        String salida = String.format("Factura nro %s:\n", this.id);
        salida += String.format("\t%s\n",this.cliente);
        salida += "\tItems de la factura:\n";

        Integer maximaLongitud = this.detalleFactura.stream()
                .mapToInt(detalle -> String.format(
                                "\t\t-%sx%s",
                                detalle.getCantidad(),
                                detalle.getItem().getNombre()).length()
                ).max()
                .getAsInt();

        String padding = new String(new char[maximaLongitud + 6]).replace("\0", ".");
        for(DetalleFactura detalle : detalleFactura){
            String aux = String.format(
                    "\t\t-%sx%s",
                    detalle.getCantidad(),
                    detalle.getItem().getNombre());
            salida += aux + padding.substring(aux.length());
            salida += String.format(
                    "$%s =======> $%s\n",
                    detalle.getPrecio(),
                    detalle.getTotal()
            );
        };
        salida += String.format("\tTOTAL: $%s", this.calcularTotal());
        return salida;
    }
}
