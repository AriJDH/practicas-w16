package ejercicioIntegrador;

import java.util.ArrayList;
import java.util.List;

public class AbsEntityCrud <T> implements EntityCrud<T> {

    protected List<T> entities;

    public AbsEntityCrud() {
        this.entities = new ArrayList<>();
    }

    @Override
    public T add(T anEntity) {
        entities.add(anEntity);
        return anEntity;
    }

    @Override
    public void remove(T anEntity) {
        entities.remove(anEntity);
    }

    @Override
    public List<T> getAll() {
        return entities;
    }

    @Override
    public void update(T anEntityToUpdate, T anUpdatedEntity) {
        entities.remove(anEntityToUpdate);
        entities.add(anUpdatedEntity);
    }
}
