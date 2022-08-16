package bootcamp.supermecado.repository;

import java.util.Collection;

public interface ICrudRepository {
    void crear(Object o);
    Object get(Integer id);
    void eliminar(Integer id);
    Collection<Object> getTodos();
}
