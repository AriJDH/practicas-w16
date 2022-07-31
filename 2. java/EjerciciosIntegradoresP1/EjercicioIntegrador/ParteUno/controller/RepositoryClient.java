package EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.model.Cliente;

public class RepositoryClient implements Repository<Cliente> {

    private Collection<Cliente> items;

    public RepositoryClient() {
        this.items = new ArrayList<Cliente>();
    }

    @Override
    public void add(Cliente item) {
        this.items.add(item);
    }

    @Override
    public void remove(Cliente item) {
        this.items.remove(item);
    }

    @Override
    public void update(Cliente item) {
        this.items.remove(item);
        this.items.add(item);
    }

    @Override
    public Cliente get(FilterType ...filters) {
        Field[] fields = items.size() > 0 ? items.iterator().next().getClass().getDeclaredFields() : null;

        Cliente response = null;
        for (Cliente item : this.items) {
            boolean match = false;
            for (FilterType filter : filters) {
                for (Field field : fields) {
                    if (field.getName().equals(filter.type)) {
                        if (item.get(field.getName()).equals(filter.value)) {
                            match = true;
                        }
                    }
                }
            }
            if (match) {
                response = item;
                break;
            }
        }
        return response;
    }

    @Override
    public boolean delete(FilterType ...filters) {
        Field[] fields = items.size() > 0 ? items.iterator().next().getClass().getDeclaredFields() : null;
        boolean match = false;

        for (Cliente item : this.items) {
            for (FilterType filter : filters) {
                for (Field field : fields) {
                    if (field.getName().equals(filter.type)) {
                        if (item.get(field.getName()).equals(filter.value)) {
                            match = true;
                        }
                    }
                }
            }
            if (match) {
                this.items.remove(item);
                match = true;
                break;
            }
        }

        return match;
    }

    @Override
    public Collection<Cliente> getAll() {
        return items;
    }
    
}
