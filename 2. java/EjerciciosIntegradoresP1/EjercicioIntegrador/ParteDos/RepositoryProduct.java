package EjerciciosIntegradoresP1.EjercicioIntegrador.ParteDos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.controller.FilterType;
import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.controller.Repository;
import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.model.Item;

public class RepositoryProduct implements Repository<Item>{

    private Collection<Item> items;

    public RepositoryProduct() {
        this.items = new ArrayList<Item>();
    }

    
    /** 
     * @param item
     */
    @Override
    public void add(Item item) {
        this.items.add(item);
    }

    
    /** 
     * @param item
     */
    @Override
    public void remove(Item item) {
        this.items.remove(item);
    }

    
    /** 
     * @param item
     */
    @Override
    public void update(Item item) {
        
    }

    
    /** 
     * @param item
     * @return Item
     */
    @Override
    public Item get(Item item) {
        return this.items.contains(item) ? item : null;
    }

    
    /** 
     * @param labels
     * @return Item
     */
    @Override
    public Item get(FilterType... labels) {
        Field[] fields = items.size() > 0 ? items.iterator().next().getClass().getDeclaredFields() : null;
        Item response = null;

        for (Item item : this.items) {
            boolean match = false;
            for (FilterType filter : labels) {
                for (Field field : fields) {
                    if (field.getName().equals(filter.getType())) {
                        if (item.get(field.getName()).equals(filter.getValue())) {
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

    
    /** 
     * @param labels
     * @return boolean
     */
    @Override
    public boolean delete(FilterType... labels) {
        Field[] fields = items.size() > 0 ? items.iterator().next().getClass().getDeclaredFields() : null;
        boolean match = false;
        for (Item item : this.items) {
            for (FilterType filter : labels) {
                for (Field field : fields) {
                    if (field.getName().equals(filter.getType())) {
                        if (item.get(field.getName()).equals(filter.getValue())) {
                            match = true;
                        }
                    }
                }
            }
            if (match) {
                this.items.remove(item);
                break;
            }
        }
        return match;
    }

    
    /** 
     * @return Collection<Item>
     */
    @Override
    public Collection<Item> getAll() {
        return items;
    }
    
}
