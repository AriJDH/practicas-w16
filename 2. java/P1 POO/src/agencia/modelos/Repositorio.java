package agencia.modelos;

public interface Repositorio<T> {
  public void guardar(T t);
  public void eliminar(T t);
  public void imprimir(T t);

}
