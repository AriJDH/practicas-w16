package practicesIntegrator1Live.models;

public interface Repositorio<T> {
  public void guardar(T t);
  public void eliminar(T t);
  public void imprimir(T t);

}
