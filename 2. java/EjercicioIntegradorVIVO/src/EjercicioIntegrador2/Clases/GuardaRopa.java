package EjercicioIntegrador2.Clases;

import java.util.*;

public class GuardaRopa {

    private Integer contador=0;

    List<Prenda> listaPrenda = new ArrayList<>();
    Map<Integer, List> bodegaRopa = new HashMap<Integer, List>();

    public GuardaRopa(List<Prenda> listaPrenda) {
        this.listaPrenda = listaPrenda;
    }

    public Integer guardarPrendas(List<Prenda>listaPrenda){
        contador=contador+1;
        System.out.println("Listado de prendas se guardaron con identificador: "+contador );
        System.out.println("La lista de prendas que se guardaron fueron: "+listaPrenda);
        bodegaRopa.put(contador,listaPrenda);
        return contador;
    }
    public void retirarPrendas(int id){
        System.out.println("Se retirara "+ bodegaRopa.get(id));
        bodegaRopa.remove(id);
        System.out.println("Lista retirada y entregada");
    }
    public void consultarListado(int id){
        if(!Objects.isNull(bodegaRopa.get(id))){
            System.out.println("La prenda con ID "+id+" Pertenece a "+bodegaRopa.get(id));
        }else{
            System.out.println("La prenda con ID "+id+" No se encuentra, intente con otro");
        }

    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }


    public Map<Integer, List> getBodegaRopa() {
        return bodegaRopa;
    }

    public void setBodegaRopa(Map<Integer, List> bodegaRopa) {
        this.bodegaRopa = bodegaRopa;
    }
}
