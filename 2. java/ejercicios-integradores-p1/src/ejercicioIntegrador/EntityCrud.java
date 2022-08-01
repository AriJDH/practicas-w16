package ejercicioIntegrador;

import java.util.List;

public interface EntityCrud <T> {

    public T add(T anEntity);

    public void remove(T anEntity);

    public List<T> getAll();

    public void update(T anEntityToUpdate, T anUpdatedEntity);

}
