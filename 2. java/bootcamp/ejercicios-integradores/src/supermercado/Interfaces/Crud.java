package supermercado.Interfaces;

import java.util.Collection;

public interface Crud {

    void crear(Object o);

    Object get(String id);

    void eliminar(String id);

    Collection<Object> getTodos();



}
