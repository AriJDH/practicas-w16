package ropero;

import ropero.clases.GuardaRopa;
import ropero.clases.Prenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[]args){

        //Crear en la clase Main un escenario en el cual alguien guarde dos prendas, reciba el código y luego consulta por sus prendas guardadas.

        Prenda pantalon = new Prenda("Maui n sons","jeans azul");
        Prenda camisa = new Prenda("Maui n sons","camisa rosa");


        Prenda chaqueta = new Prenda("Maui n sons","chaqueta roja");
        Prenda bufanda = new Prenda("Maui n sons","bufanda rosa");

        List<Prenda> prendas = new ArrayList<>();
        List<Prenda> prendas2 = new ArrayList<>();

        prendas.add(pantalon);
        prendas.add(camisa);

        prendas2.add(chaqueta);
        prendas2.add(bufanda);



        Map <Integer,List<Prenda>> mapa = new HashMap<>();
        GuardaRopa guardaRopa = new GuardaRopa(0, mapa);

        GuardaRopa guardaRopa2 = new GuardaRopa(guardaRopa.getId()+1, mapa);


        Integer poscion = guardaRopa.guardarRopa(prendas);

        System.out.println("Las prendas se encuentran en el roper : "+poscion);

        guardaRopa.mostrarPrendas();

        System.out.println("las prendas del ropero:"+guardaRopa.getId()+" Son: "+guardaRopa.devolverPrenda(guardaRopa.getId()));


        Integer poscion2 = guardaRopa2.guardarRopa(prendas2);
        System.out.println("Las prendas se encuentran en el ropero : "+poscion2);
        
        guardaRopa2.mostrarPrendas();

        System.out.println("las prendas del ropero:"+guardaRopa2.getId()+" Son: "+guardaRopa2.devolverPrenda(guardaRopa.getId()));
    }
}
