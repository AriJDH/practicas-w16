package EjercicioIntegrador.interfaces;

import java.util.List;
import java.util.Optional;

public interface RepositoryCrud <T>{
    public void guardar (T objeto);
    public void mostrarPantalla();
    public Optional<T> buscar (int id);
    public void eliminar (int id);
    public List<T> traerDatos();
}
