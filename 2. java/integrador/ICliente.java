package integrador;

public interface ICliente {
    String toString();
    String getNombre();
    void setNombre(String nombre);
    String getApellido();
    void setApellido(String apellido);
    Integer getDni();
    void setDni(Integer dni);
    void agregarItemFacturaById(Integer facturaId, IItemFactura itemFactura);
    IFactura obtenerFacturaById(Integer id);
    void borrarItemByFacturaIdCodigo(Integer facturaId, Integer codigo);
}
