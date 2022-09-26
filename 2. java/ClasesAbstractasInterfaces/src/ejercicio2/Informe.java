package ejercicio2;

public class Informe implements Imprimible {
  private String texto;
  private Integer paginas;
  private String autor;
  private String revisor;

  public Informe(String texto, Integer paginas, String autor, String revisor) {
    this.texto = texto;
    this.paginas = paginas;
    this.autor = autor;
    this.revisor = revisor;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
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

  public String getRevisor() {
    return revisor;
  }

  public void setRevisor(String revisor) {
    this.revisor = revisor;
  }

  @Override
  public void imprimir() {
    StringBuilder mensaje = new StringBuilder();
    mensaje.append("Informe escrito por ")
        .append(this.autor)
        .append(" revisado por " + this.revisor + ",")
        .append(" con " + this.paginas + " paginas.");
    System.out.println(mensaje);
  }
}
