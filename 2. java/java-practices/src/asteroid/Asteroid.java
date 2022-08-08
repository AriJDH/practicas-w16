package asteroid;

import java.util.ArrayList;
import java.util.List;

public class Asteroid {
    private List<Participante> listaDeParticipantes;

    public Asteroid(List<Participante> listaDeParticipantes){
        this.listaDeParticipantes = listaDeParticipantes;
    }

    public List<Participante> getListaDeParticipantes() {
        return this.listaDeParticipantes;
    }

    public void setListaDeParticipantes(List<Participante> listaDeParticipantes) {
        this.listaDeParticipantes = listaDeParticipantes;
    }

    public void iniciarJuego(List<Coordenada> listaDeCoordenadasObjetivo){
        System.out.println("¡JUEGO INICIADO!\n");

        int ronda = 0;
        for(Coordenada coordenadaObjetivo: listaDeCoordenadasObjetivo){
            ronda++;
            List<Double> listaDeDistanciasRondaActual = new ArrayList();

            // Se calculan las distancias al objetivo
            System.out.println("RONDA " + ronda);
            for(Participante participante: this.listaDeParticipantes){
                Double distanciaObtenida = participante.getComponente().calcularDistancia(coordenadaObjetivo);
                listaDeDistanciasRondaActual.add(distanciaObtenida);

                // Se muestra la distancia obtenida por el participante
                System.out.println(". El participante " + participante + " ha obtenido una distancia de " + distanciaObtenida + ".");
            }

            // Se determina la menor distancia
            int indexMenorDistancia = this.getIndexMenorDistancia(listaDeDistanciasRondaActual);
            System.out.println("> El participante " + listaDeParticipantes.get(indexMenorDistancia) + " ha ganado la ronda con la distancia obtenida de " +
                                listaDeDistanciasRondaActual.get(indexMenorDistancia) + ".\n");

            // Se asigna puntaje al ganador
            Participante participanteGanadorDeRondaActual = listaDeParticipantes.get(indexMenorDistancia);
            int puntuacionParticipanteGanadorDeRondaActual = participanteGanadorDeRondaActual.getComponente().getPuntuacion();
            participanteGanadorDeRondaActual.getComponente().setPuntuacion(puntuacionParticipanteGanadorDeRondaActual+1);
        }

        // Se determina el ganador del juego
        Participante participante = this.getListaDeParticipantes().get(this.getIndexParticipanteGanador());
        System.out.println("JUEGO FINALIZADO: El participante " + participante + " es el ganador de Asteroid con " + participante.getComponente().getPuntuacion() + " puntos.");
    }

    private int getIndexMenorDistancia(List<Double> listaDeDistanciasRondaActual){
        int indexMenorDistancia = 0;
        Double menorDistancia = listaDeDistanciasRondaActual.get(indexMenorDistancia);
        for(int i=0; i<listaDeDistanciasRondaActual.size(); i++){
            Double distanciaActual = listaDeDistanciasRondaActual.get(i);
            if(distanciaActual < menorDistancia){
                indexMenorDistancia = i;
                menorDistancia = distanciaActual;
            }
        }

        return indexMenorDistancia;
    }

    private int getIndexParticipanteGanador(){
        int indexParticipanteConMayorPuntuacion = 0;
        Integer mayorPuntuacion = this.listaDeParticipantes.get(indexParticipanteConMayorPuntuacion).getComponente().getPuntuacion();
        for(int i=0; i<this.listaDeParticipantes.size(); i++){
            Integer puntuacionParticipanteActual = this.listaDeParticipantes.get(i).getComponente().getPuntuacion();
            if(puntuacionParticipanteActual > mayorPuntuacion){
                indexParticipanteConMayorPuntuacion = i;
                mayorPuntuacion = puntuacionParticipanteActual;
            }
        }

        return indexParticipanteConMayorPuntuacion;
    }
}
