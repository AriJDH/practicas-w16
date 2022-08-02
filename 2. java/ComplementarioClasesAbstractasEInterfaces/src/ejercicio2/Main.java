package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Nave nave1 = new Nave("1",5,2);
        Nave nave2 = new Nave("2",2,22);
        Nave nave3 = new Nave("3",32,12);
        Nave nave4 = new Nave("4",12,24);
        Nave nave5 = new Nave("5",23,11);
        Nave nave6 = new Nave("6",3,9);
        Nave nave7 = new Nave("7",8,7);
        Nave nave8 = new Nave("8",16,14);

        List<Nave> listaNaves1 = new ArrayList();
        listaNaves1.add(nave1);
        listaNaves1.add(nave2);
        Icompetidor competidor1 = new FlotaNave(listaNaves1);
        Icompetidor competidor2 = new NaveSimple(nave3);
        List<Nave> listaNaves2 = new ArrayList();
        listaNaves2.add(nave4);
        listaNaves2.add(nave5);
        Icompetidor competidor3 = new FlotaNave(listaNaves2);
        Icompetidor competidor4 = new NaveSimple(nave6);
        Icompetidor competidor5 = new NaveSimple(nave7);
        Icompetidor competidor6 = new NaveSimple(nave8);

        List<Icompetidor> listaCompetidores = new ArrayList<>();
        listaCompetidores.add(competidor1);
        listaCompetidores.add(competidor2);
        listaCompetidores.add(competidor3);
        listaCompetidores.add(competidor4);
        listaCompetidores.add(competidor5);
        listaCompetidores.add(competidor6);

        int[] coordenadasX = {12,52,33,24,31};
        int[] coordenadasY = {32,14,25,32,44};
        Competencia competencia = new Competencia(listaCompetidores,coordenadasX,coordenadasY);

        competencia.ejecutarCompetencia();

    }
}
