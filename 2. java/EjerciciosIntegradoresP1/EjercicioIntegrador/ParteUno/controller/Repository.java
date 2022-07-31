package EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.controller;

import java.util.Collection;

public interface Repository<T> {
    void add(T item);

    void remove(T item);

    void update(T item);

    T get(FilterType ...labels);

    T get(T item);

    boolean delete(FilterType ...labels);

    Collection<T> getAll();
}
