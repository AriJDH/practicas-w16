package integrador;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements ICliente {
    private String nombre;
    private String apellido;
    private Integer dni;
    private final List<IFactura> facturas = new ArrayList<>();
    public Cliente(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }
    @Override
    public void agregarItemFacturaById(Integer facturaId, IItemFactura itemFactura) {
        IFactura factura = this.obtenerFacturaById(facturaId);
        if(factura ==  null) {
            System.out.println("La factura no existe!");
            return;
        }
        factura.getItems().add(itemFactura);
    }
    @Override
    public IFactura obtenerFacturaById(Integer facturaId) {
        return this.facturas.stream()
                .filter(user -> user.getId().equals(facturaId))
                .findFirst()
                .orElse(null);
    }

    public void borrarItemByFacturaIdCodigo(Integer facturaId, Integer codigo) {
        IFactura factura = this.obtenerFacturaById(facturaId);
        if(factura ==  null) {
            System.out.println("La factura no existe!");
            return;
        }
        factura.getItems().removeIf(facturaItem -> codigo == facturaItem.getItem().getCodigo());
    }


}
