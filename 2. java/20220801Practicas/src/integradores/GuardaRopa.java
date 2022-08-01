package integradores;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> armario;
    private int contador;

    public GuardaRopa() {
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

    public Integer guardarPrendas(List<Prenda> lista){
        contador++;
        armario.put(contador,lista);

        return contador;
    }

    public void mostrarPrendas(){
        armario.forEach((clave, prenda) -> {
            System.out.println("Identificador: " + clave);
            System.out.println("Prendas: ");
            prenda.forEach(System.out::println);
        });
    }

    public List<Prenda> devolverPrendas(int x){
        List<Prenda> inicial = armario.get(x);
        armario.remove(x);
        return inicial;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "armario=" + armario +
                ", contador=" + contador +
                '}';
    }
}
