package localizadores;

import java.util.ArrayList;
import java.util.List;

public class Localizadores {

    private List<Localizador> listaLocalizador = new ArrayList<>();

    public List<Localizador> getListaLocalizador() {
        return listaLocalizador;
    }

    public void setListaLocalizador(List<Localizador> listaLocalizador) {
        this.listaLocalizador = listaLocalizador;
    }

    public boolean tieneMasdeDosLocalizadoresCliente(Localizador localizador){
        long contador = 0;
        contador = listaLocalizador.stream()
                .filter(x-> x.getCliente().getDni() == localizador.getCliente().getDni())
                .count();

        return contador>=2;
    }

    public Localizador calcularTotal1(Localizador localizador){
        double total = localizador.calcularTotal();
        if (tieneMasdeDosLocalizadoresCliente(localizador)){
            total = total - total*(0.1);
        }
        localizador.setTotal(total);
        System.out.println(localizador);
        return localizador;
    }

    public void addLocalizador(Localizador localizador){
        localizador = this.calcularTotal1(localizador);
        listaLocalizador.add(localizador);
    }

    @Override
    public String toString() {
        return "Localizadores{" +
                "listaLocalizador=" + listaLocalizador +
                '}';
    }
}
