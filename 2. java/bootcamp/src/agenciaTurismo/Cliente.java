package agenciaTurismo;

public class Cliente {
  private String nombre;
  private Integer edad;
  private Integer dni;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public Integer getDni() {
    return dni;
  }

  public void setDni(Integer dni) {
    this.dni = dni;
  }

  public Cliente() {
  }

  public Cliente(String nombre, Integer edad, Integer dni) {
    this.nombre = nombre;
    this.edad = edad;
    this.dni = dni;
  }

  @Override
  public String toString() {
    return "Cliente{" +
        "nombre='" + nombre + '\'' +
        ", edad=" + edad +
        ", dni=" + dni +
        '}';
  }
}
