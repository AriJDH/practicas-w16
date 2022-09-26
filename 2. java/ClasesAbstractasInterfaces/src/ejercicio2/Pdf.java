package ejercicio2;

public class Pdf implements Imprimible {
  private Integer paginas;
  private String autor;
  private String genero;
  private String titulo;

  public Pdf(Integer paginas, String autor, String genero, String titulo) {
    this.paginas = paginas;
    this.autor = autor;
    this.genero = genero;
    this.titulo = titulo;
  }

  public Integer getPaginas() {
    return paginas;
  }

  public void setPaginas(Integer paginas) {
    this.paginas = paginas;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  @Override
  public void imprimir() {
    StringBuilder mensaje = new StringBuilder();
    mensaje.append("PDF escrito por ")
        .append(this.autor)
        .append(" titulado " + this.titulo + ",")
        .append(" de genero " + this.genero)
        .append(" con " + this.paginas + " paginas.");
    System.out.println(mensaje);
  }
}
