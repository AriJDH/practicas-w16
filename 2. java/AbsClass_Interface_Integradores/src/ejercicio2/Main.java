package ejercicio2;

import ejercicio2.Clases.FlotaDeNaves;
import ejercicio2.Clases.NaveSimple;
import ejercicio2.Clases.Participante;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Primer participante con una nave simple
        NaveSimple furiaRoja = new NaveSimple("Furia Roja", generarCoordenada(), generarCoordenada());
        Participante bolido = new Participante("Bólido", furiaRoja, 0);

        //Segundo participante con una flota de naves
        List<NaveSimple> flotaDeNaves = Arrays.asList(
                new NaveSimple("Nave a", generarCoordenada(), generarCoordenada()),
                new NaveSimple("Nave b", generarCoordenada(), generarCoordenada()),
                new NaveSimple("Nave c", generarCoordenada(), generarCoordenada()),
                new NaveSimple("Nave d", generarCoordenada(), generarCoordenada()),
                new NaveSimple("Nave e", generarCoordenada(), generarCoordenada())
        );
        FlotaDeNaves flota1 = new FlotaDeNaves(flotaDeNaves);
        Participante jineteSable = new Participante("Jinete Sable", flota1, 0);

        //Tercer participante con una nave simple
        NaveSimple poderMontado = new NaveSimple("Poder Montado", generarCoordenada(), generarCoordenada());
        Participante potro = new Participante("Potro", poderMontado, 0);

        System.out.println("Eje x: " + bolido.getNaveSimple().getX());
        System.out.println("Eje y: " + bolido.getNaveSimple().getY());
        System.out.println(furiaRoja.destruirAsteroide());
        System.out.println(flota1.destruirAsteroide());
        System.out.println(poderMontado.destruirAsteroide());



    }

    private static int generarCoordenada(){
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
