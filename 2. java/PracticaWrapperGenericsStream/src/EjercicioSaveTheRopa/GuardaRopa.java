package EjercicioSaveTheRopa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> dicc;
    private Integer cont = 0;

    public GuardaRopa() {

        dicc = new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getDicc() {
        return dicc;
    }

    public void setDicc(Map<Integer, List<Prenda>> dicc) {
        this.dicc = dicc;
    }

    public Integer getCont() {
        return cont;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "dicc=" + dicc +
                ", cont=" + cont +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){

        cont++;
        dicc.put(cont, listaDePrenda);

        return cont;

    }

    public void mostrarPrendas(){

        for(int i = 0; i < cont; i++){
            System.out.println("Número identificador" + i);
            System.out.println("Prendas: " + dicc.get(i));
        }

    }

    public List<Prenda> devolverPrendas(Integer numero){

        List<Prenda> lista = dicc.get(numero);

        if(lista == null){
            System.out.println("No se encuentran prendas con ese código.");
            return lista;
        } else {
            return lista;
        }

    }
}
