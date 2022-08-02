package practica.ejerciciosintegradores.p1.vivo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Repositorio {

    private static Repositorio repositorioSingleton = null;
    protected HashMap<Integer, ArrayList<Localizador>> localizadores = new HashMap<Integer, ArrayList<Localizador>>();

    public Repositorio(HashMap<Integer, ArrayList<Localizador>> localizadores) {
        this.localizadores = localizadores;
    }

    public HashMap<Integer, ArrayList<Localizador>> getLocalizadores() {
        return this.localizadores;
    }

    public void setLocalizadores(HashMap<Integer, ArrayList<Localizador>> localizadores) {
        this.localizadores = localizadores;
    }

    private Repositorio() {}

    public static Repositorio getInstance() {
        if (repositorioSingleton == null) {
            repositorioSingleton = new Repositorio();
        }
        return repositorioSingleton;
    }

    public void addLocalizador(Integer dni, Localizador localizador) {
        if (this.getLocalizadoresPorCliente(dni) == null) {
            ArrayList<Localizador> localizadores = new ArrayList<>(Arrays.asList(localizador));
            this.getLocalizadores().put(dni, localizadores);
            return;
        }
        this.getLocalizadoresPorCliente(dni).add(localizador);
    }

    public int getTotalLocalizadoresPorCliente(Integer dni) {
        if (this.getLocalizadores().get(dni) == null) {
            return 0;
        }
        return this.localizadores.get(dni).size();
    }

    public ArrayList<Localizador> getLocalizadoresPorCliente(int dni) {
        return this.localizadores.get(dni);
    }

}
