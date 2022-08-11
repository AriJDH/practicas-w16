package integrador.supermercado.interfaces;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, U> {
    Optional<T> findOne(U identificador);
    List<T> getAll();
    T save(T object);
    Boolean delete(U identificador);
}
