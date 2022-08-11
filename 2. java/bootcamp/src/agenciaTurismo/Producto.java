package agenciaTurismo;

import java.util.List;

public class Producto {
  private TipoProducto tipoProducto;
  private Double precio;
  private String descripcion;

  public TipoProducto getTipoProducto() {
    return tipoProducto;
  }

  public void setTipoProducto(TipoProducto tipoProducto) {
    this.tipoProducto = tipoProducto;
  }

  public Double getPrecio() {
    return precio;
  }

  public void setPrecio(Double precio) {
    this.precio = precio;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Producto(TipoProducto tipoProducto) {
    this.tipoProducto = tipoProducto;
  }

  public Producto(TipoProducto tipoProducto, Double precio, String descripcion) {
    this.tipoProducto = tipoProducto;
    this.precio = precio;
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    return "Producto{" +
        "tipoProducto=" + tipoProducto +
        ", precio=" + precio +
        ", descripcion='" + descripcion + '\'' +
        '}';
  }
}
