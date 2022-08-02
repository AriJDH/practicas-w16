package Repositorios;

import Servicios.*;

import java.util.ArrayList;
import java.util.List;

public class RepoLocalizador {

    private List<Localizador> localizador = new ArrayList<>();

    public RepoLocalizador(List<Localizador> localizador) {
        this.localizador = localizador;
    }

    public List<Localizador> getLocalizador() {
        return localizador;
    }

    public void setLocalizador(List<Localizador> localizador) {
        this.localizador = localizador;
    }

    public double calcularFuturoDescuento(){
        double costoCalculado = 0;
        double cantidadDescuento = 0;
        int contador = 0;
        for (Localizador localizadores : localizador){
            costoCalculado += localizadores.getCostoTotal();
            contador++;
        }
        if (contador >= 2){
            cantidadDescuento = costoCalculado * 0.05;
        }
        return cantidadDescuento;
    }
}
