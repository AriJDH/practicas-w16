package integrador.p2_prenda.repository;

import integrador.p2_prenda.interfaces.IRepositorio;
import integrador.p2_prenda.model.Prenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa implements IRepositorio {
    private HashMap<Integer, List<Prenda>> prendas;
    private Integer id;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.id = 0;
    }

    @Override
    public Integer guardarPrendas(List<Prenda> prendas) {
        this.id++;
        this.prendas.put(this.id, prendas);
        return this.id;
    }

    @Override
    public List<Prenda> devolverPrenda(Integer id) {
        return this.prendas.get(id);
    }

    @Override
    public void mostrarPrendas() {
        System.out.println("GuardaRopa:");
        this.prendas.forEach((id, prenda) -> System.out.printf("\t-ID: %s\n\t-PRENDAS: %s\n", id, prenda));
    }
}
