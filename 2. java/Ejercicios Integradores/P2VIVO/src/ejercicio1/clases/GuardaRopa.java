package ejercicio1.clases;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> armario;
    private int contador;

    public GuardaRopa(){
        armario = new HashMap<>();
    }

    public HashMap<Integer, List<Prenda>> getArmario() {
        return armario;
    }

    public void setArmario(HashMap<Integer, List<Prenda>> armario) {
        this.armario = armario;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaPrenda){
        this.contador++;
        armario.put(contador, listaPrenda);
        return this.contador;
    }

    public void mostrarPrendas(){
        System.out.println("--- PRENDAS GUARDADAS ---");
        armario.forEach((integer, prendas) -> {
            System.out.println("Identificador: " + integer);
            System.out.println("Prendas: ");
            prendas.forEach(System.out::println);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> listaPrendas = armario.get(numero);
        armario.remove(numero);
        return listaPrendas;
    }
}
