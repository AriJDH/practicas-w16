package ejercicio2;

import ejercicio2.Clases.FlotaDeNaves;
import ejercicio2.Clases.NaveSimple;
import ejercicio2.Clases.Participante;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Primer participante con una nave simple
        NaveSimple nave1 = new NaveSimple("Furia Roja", generarNumero(), generarNumero());
        Participante participante1 = new Participante("Bólido", nave1, 0);

        //Segundo participante con una flota de naves
        List<NaveSimple> flotaDeNaves = Arrays.asList(
                new NaveSimple("Nave 1", generarNumero(), generarNumero()),
                new NaveSimple("Nave 2", generarNumero(), generarNumero()),
                new NaveSimple("Nave 3", generarNumero(), generarNumero()),
                new NaveSimple("Nave 4", generarNumero(), generarNumero())
        );
        FlotaDeNaves flota1 = new FlotaDeNaves(flotaDeNaves);
        Participante participante2 = new Participante("Jinete Sable", flota1, 0);

        //Tercer participante con una nave simple
        NaveSimple nave2 = new NaveSimple("Poder Montado", generarNumero(), generarNumero());
        Participante participante3 = new Participante("Potro", nave2, 0);

        System.out.println("Eje x: " + participante1.getNaveSimple().getX());
        System.out.println("Eje y: " + participante1.getNaveSimple().getY());
        System.out.println(nave1.destruirAsteroide());
        System.out.println(flota1.destruirAsteroide());
        System.out.println(nave2.destruirAsteroide());



    }

    private static int generarNumero(){
        //Se define un rango de coordenadas en un plano de 100 x 100
        int min = 0;
        int max = 100;
        int rango = max - min + 1;
        int rand = 0;

        for (int i = 0; i < 100; i++) {
            rand = (int)(Math.random() * rango) + min;
        }
        return rand;
    }
}
