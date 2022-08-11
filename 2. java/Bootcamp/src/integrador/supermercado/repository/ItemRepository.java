package integrador.supermercado.repository;

import integrador.supermercado.interfaces.IRepository;
import integrador.supermercado.models.Item;
import integrador.supermercado.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class ItemRepository implements IRepository<Item, String> {
    private List<Item> items;

    public static ItemRepository instance;

    private ItemRepository() {
        this.items = new ArrayList<>();
    }

    public static ItemRepository getInstance(){
        if(instance == null) instance = new ItemRepository();
        return instance;
    }

    @Override
    public Optional<Item> findOne(String identificador) {
        return this.items.stream()
                .filter(c->c.getCodigo().equalsIgnoreCase(identificador))
                .findFirst();
    }

    @Override
    public List<Item> getAll() {
        return this.items;
    }

    @Override
    public Item save(Item object) {
        this.items.add(object);
        return object;
    }

    @Override
    public Boolean delete(String identificador) {
        Optional<Item> factura = this.findOne(identificador);
        if(factura.isEmpty()) return Boolean.FALSE;
        this.items.remove(factura.get());
        return Boolean.TRUE;
    }
}
