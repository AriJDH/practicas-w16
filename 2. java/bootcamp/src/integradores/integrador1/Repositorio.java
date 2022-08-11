package integradores.integrador1;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T> {

    public void add(T obj);
    public void delete(Long id);
    public void update(T obj, T newObj);
    public T get(Long id);
    public boolean has(Long id);
    public List<T> getAll();

}
