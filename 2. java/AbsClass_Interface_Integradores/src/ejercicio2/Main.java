package ejercicio2;

import ejercicio2.Clases.*;
import ejercicio2.AbstractClasses.Participante;
import ejercicio2.Interfaces.Nave;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Se define un array para almacenar a todos los participantes
        List<Participante> participantes = new ArrayList<>();

        //Primer participante con una nave simple
        NaveSimple furiaRoja = new NaveSimple("Furia Roja", 0, 0);
        ParticipanteNave bolido = new ParticipanteNave("Bólido", furiaRoja, 0);
        participantes.add(bolido);

        //Segundo participante con una flota de naves
        List<NaveSimple> flotaDeNaves = Arrays.asList(
                new NaveSimple("Nave a", 0, 0),
                new NaveSimple("Nave b", 0, 0),
                new NaveSimple("Nave c", 0, 0),
                new NaveSimple("Nave d", 0, 0),
                new NaveSimple("Nave e", 0, 0)
        );
        FlotaDeNaves flota1 = new FlotaDeNaves(flotaDeNaves);
        ParticipanteFlota jineteSable = new ParticipanteFlota("Jinete Sable", flota1, 0);
        participantes.add(jineteSable);

        //Tercer participante con una nave simple
        NaveSimple poderMontado = new NaveSimple("Poder Montado", 0, 0);
        ParticipanteNave potro = new ParticipanteNave("Potro", poderMontado, 0);
        participantes.add(potro);

        //Cuarto participante con una flota de naves
        List<NaveSimple> flotaAzul = Arrays.asList(
                new NaveSimple("Nave f", 0, 0),
                new NaveSimple("Nave g", 0, 0),
                new NaveSimple("Nave h", 0, 0),
                new NaveSimple("Nave i", 0, 0),
                new NaveSimple("Nave j", 0, 0)
        );
        FlotaDeNaves flota2 = new FlotaDeNaves(flotaAzul);
        ParticipanteFlota jessieAzul = new ParticipanteFlota("Jessie Azul", flota2, 0);
        participantes.add(jessieAzul);

        /*Se crean dos listas de participantes, una que contiene participantes con
        naves simples y otra que contiene participantes con flotas de naves*/

        List<ParticipanteNave> participanteNaveList = Arrays.asList(bolido, potro);
        List<ParticipanteFlota> participanteFlotaList = Arrays.asList(jineteSable, jessieAzul);

        //Se define la cantidad de rondas a jugar
        int rondas = 5;

        //Comienza la partida
        System.out.println("******* COMIENZA EL JUEGO *******");
        for (int i = 0; i < rondas; i++){

            //Se crea un asteroide con coordenadas aleatorias
            Asteroide asteroid = new Asteroide(generarCoordenada(), generarCoordenada());

            System.out.println("Coordenadas del asteroide: (x:" + asteroid.getPosx() + ", y:" + asteroid.getPosy() + ")");

            Double[] resultados = new Double[participantes.size()];
            int index = 0;

            /*Se generan coordenadas aleatorias para las naves simples y
            se calcula la distancia respecto del asteroide para cada nave*/
            for (int x = 0; x < participanteFlotaList.size(); x++){
                participanteNaveList.get(x).getNaveSimple().setX(generarCoordenada());
                participanteNaveList.get(x).getNaveSimple().setY(generarCoordenada());
                resultados[index] = participanteNaveList.get(x).getNaveSimple().destruirAsteroide(asteroid);
                index++;
            }

            /*Se generan coordenadas aleatorias para las flotas de naves y
            se calcula la distancia respecto del asteroide para la flota completa*/
            for (int j = 0; j < participanteFlotaList.size(); j++){
                participanteFlotaList.get(j).getFlotaDeNaves().getFlota().get(j).setX(generarCoordenada());
                participanteFlotaList.get(j).getFlotaDeNaves().getFlota().get(j).setY(generarCoordenada());
                resultados[index] = participanteFlotaList.get(j).getFlotaDeNaves().destruirAsteroide(asteroid);
                index++;
            }

            //Se imprimen los resultados
            for (int x = 0; x < participantes.size(); x++){
                System.out.println("Resultado de la nave o naves de " + participantes.get(x).getNombre() + ": " + resultados[x]);
            }

            /*Se obtiene el resultado mínimo de la ronda y su posición dentro del arreglo,
            el cual se utiliza para determinar al ganador de la ronda*/
            Double minValue = Collections.min(Arrays.asList(resultados));
            int posicion = Arrays.asList(resultados).indexOf(minValue);
            participantes.get(posicion).setPuntuacion(participantes.get(posicion).getPuntuacion() + 1);
            System.out.println("¡El participante " + participantes.get(posicion).getNombre() + " gana la ronda!");
            System.out.println("Puntuacion Actual de "+ participantes.get(posicion).getNombre() + ": " + participantes.get(posicion).getPuntuacion());
            System.out.println();
        }

        Participante ganador = participantes.stream().max(Comparator.comparingDouble(Participante::getPuntuacion)).get();
        System.out.println("¡El ganador de la partida es el participante " + ganador.getNombre() + "!");
    }

    private static int generarCoordenada(){
        //Se define un rango de coordenadas en un plano de 100 x 100
        int min = -100;
        int max = 100;
        int rango = max - min + 1;
        int rand = 0;

        for (int i = 0; i < 100; i++) {
            rand = (int)(Math.random() * rango) + min;
        }
        return rand;
    }
}
