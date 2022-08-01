package com.tomas.guardaropas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> diccionarioPrendas = new HashMap();
    private int contadorIdentificador;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){

        contadorIdentificador++;
        diccionarioPrendas.put(contadorIdentificador, listaDePrenda);
        return contadorIdentificador;
    }

    public void mostrarPrendas(){

        for(int contador = 1; contador<=contadorIdentificador; contadorIdentificador++){
            System.out.println("Prendas para el id: " + contador);
            diccionarioPrendas.get(contador).forEach(System.out::println);
        }


    }

    public List<Prenda> devolverPrendas(Integer numero) {

        return diccionarioPrendas.get(numero);
    }

}
