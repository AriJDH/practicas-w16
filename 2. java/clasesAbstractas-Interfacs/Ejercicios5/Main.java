package Ejercicios5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    /*
    Un juego llamado Asteroid, consiste en acumular puntos cuando destruye un asteroide.
     Los participantes pueden poseer una nave simple o una flota de naves simples.
      Las naves poseen un nombre, una ubicación en coordenadas (x, y) y una puntuación inicial de cero.
       Las flota de naves simples solo poseen una lista de naves simples.
        Cuando se indica unas coordenadas, la nave que gana el punto será aquella que esté más cerca,
        donde la distancia será la(x1-x2)2+(y1-y2)2 , pero en el caso de una flota de naves,
         la distancia será el promedio de distancias de las naves de la flota.
        Para poder iniciar el juego, se deben inscribir los participantes en una lista y se inicia
         el juego cuando se pasa en forma de arreglo las coordenadas donde los blancos aparecerán.
          Al finalizar se mostrará la nave o flota de naves ganadora que acumuló más puntos,
          también se deberá mostrar los resultados obtenidos para cada coordenada ingresada.
        Para desarrollar este ejercicio, se recomienda el uso de interfaces, con el uso
         del patrón de diseño Composite.
     */

        Nave nave1 = new Nave("nave1", 10, 10);
        Nave nave2 = new Nave("nave2", 20, 20);

        List<Nave> naves = new ArrayList<>();
        naves.add(new Nave("nave3", 30, 30));
        naves.add(new Nave("nave4", 40, 40));
        FlotaNaves flotaNaves = new FlotaNaves(naves);

        Participante participante1 = new Participante(nave1, "participante1");
        Participante participante2 = new Participante(nave2, "participante2");
        Participante participante3 = new Participante(flotaNaves, "participante3");
        List<Participante> participantes = new ArrayList<>();
        participantes.add(participante1);
        participantes.add(participante2);
        participantes.add(participante3);

        Meteorito meteorito = new Meteorito(10, 10);
        Meteorito meteorito2 = new Meteorito(20, 20);
        Meteorito meteorito3 = new Meteorito(30, 30);
        List<Meteorito> meteoritos = new ArrayList<>();
        meteoritos.add(meteorito);
        meteoritos.add(meteorito2);
        meteoritos.add(meteorito3);


        Asteroid asteroid = new Asteroid(participantes, meteoritos);
        asteroid.ganador();
    }
}
