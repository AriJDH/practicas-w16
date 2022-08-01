package EjercicioSupermercado;

public interface Icrud<T> {
    public T create(T t);
    public T get(String c);
    public void remove(String c);
    public void update(T t);
}
