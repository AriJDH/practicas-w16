package integradores.integrador1;

import java.util.List;

public interface Repositorio<T> {

    public void add(T obj);
    public void delete(T obj);
    public void update(T obj, T newObj);



}
