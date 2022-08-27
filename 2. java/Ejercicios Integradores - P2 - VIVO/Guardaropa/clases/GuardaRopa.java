package ropero.clases;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Integer id;

    private Map<Integer, List<Prenda>> prendas;


    public GuardaRopa() {
    }

    public GuardaRopa(Integer id, Map<Integer, List<Prenda>> prendas) {
        this.id = id;
        this.prendas = prendas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer guardarRopa(List<Prenda> prendas){
        this.prendas.put(this.id,prendas);

        return this.id;

    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "id=" + id +
                ", prendas=" + prendas +
                '}';
    }

    public void mostrarPrendas(){
        this.prendas.get(this.id)
                .stream()
                .forEach(p-> System.out.println(p.toString()));
    }

    public List<Prenda> devolverPrenda(Integer numero){
        return this.prendas.get(numero);
    }
    //Crear el método public List<Prenda> devolverPrendas(Integer numero),
    // en la Clase GuardaRopa que devuelve la lista de prendas que están guardadas bajo ese número.
}
