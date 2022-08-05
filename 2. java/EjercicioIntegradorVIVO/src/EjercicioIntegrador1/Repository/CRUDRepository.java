package EjercicioIntegrador1.Repository;

import EjercicioIntegrador1.Model.Cliente;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository <T> {
    public void save(T objeto);
    public void mostrarPantalla();

    Optional<Cliente> buscar(long id);

    public Optional<T> buscar(Long id);
    public void  eliminar(Long id);
    public List<T> traerTodos();



}
