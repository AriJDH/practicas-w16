package Ejercicio5.clases;

import java.util.ArrayList;
import java.util.List;

public class Asteroid {

    //se definen los participantes
    private List<Participante> listaParticipantes;

    public List<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public void AsteroidInicioJuego(List<Coordenada>listaDeCoordenadasRandom){
        System.out.println("¡Comienza el juego!\n");

        for(Coordenada coordenadaObjetivo: listaDeCoordenadasRandom){
            //creo una lista de distancias d todo el juego

            List<Double> listaDeDistancias = new ArrayList<>();

            for(Participante participante : this.listaParticipantes){
                Double distanciaObtenida = participante.getComposite().calcularDistancia(coordenadaObjetivo);
                listaDeDistancias.add(distanciaObtenida);
                System.out.println(". El participante " + participante + " obtuvo la distancia " + distanciaObtenida + ".");
            }
            //busco la menor distancia
            int indexMenorDistancia = this.menorDistanciaIndex(listaDeDistancias);
            System.out.println("\n" + indexMenorDistancia + "El que mas se acerca! " + this.listaParticipantes.get(indexMenorDistancia));
        }
        //busco el ganador
        Participante participanteGanador = this.getListaParticipantes().get(this.participanteGanadorIndex());
        System.out.println("\n" + participanteGanador + "los puntos " + participanteGanador.getComposite().getPuntuacion());

    }

    private int menorDistanciaIndex(List<Double> listaDeDistancias){
        int indexMenorDistancia = 0;
        Double distanciaDeEntrada = listaDeDistancias.get(indexMenorDistancia);
        for (int i = 0; i< listaDeDistancias.size(); i++){
            Double distanciaObtenida = listaDeDistancias.get(i);
            if (distanciaObtenida < distanciaDeEntrada){
                indexMenorDistancia = i;
                distanciaDeEntrada = distanciaObtenida;
            }
        }
        return indexMenorDistancia;
    }

    private int participanteGanadorIndex(){
        int indexParticipanteGanador = 0;
        int mayorCantidadDePuntos = this.listaParticipantes.get(indexParticipanteGanador).getComposite().getPuntuacion();
        for (int i = 0; i<this.listaParticipantes.size(); i++){
            int mayorCantidadDePuntosActual = this.listaParticipantes.get(i).getComposite().getPuntuacion();
            if (mayorCantidadDePuntosActual > mayorCantidadDePuntos){
            indexParticipanteGanador = i;
            mayorCantidadDePuntos = mayorCantidadDePuntosActual
            }
        }
        return indexParticipanteGanador;
    }



}
