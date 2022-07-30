package repository;

import java.util.List;
import java.util.Optional;

public interface crudRepository <T> {
    void save(T obj);
    void mostrarPantalla();
    Optional<T> buscar(Long id);
    void eliminar(Long id);
    List<T> listar();

}
