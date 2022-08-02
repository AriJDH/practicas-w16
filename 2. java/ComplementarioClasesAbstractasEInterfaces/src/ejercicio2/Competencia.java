package ejercicio2;

import java.util.List;

public class Competencia {
    private List<Icompetidor> listaNaves;



    private int[] listaCoorDenadasX;
    private int[] listaCoorDenadaY;

    public Competencia(List<Icompetidor> listaNaves, int[] listaCoorDenadasX, int[] listaCoorDenadaY) {
        this.listaNaves = listaNaves;
        this.listaCoorDenadasX = listaCoorDenadasX;
        this.listaCoorDenadaY = listaCoorDenadaY;
    }
    public int calCularGanadorRonda(int ronda){
        int ganador = -1;
        double menorDistancia = 999999;

        for (int i = 0; i < listaNaves.size(); i ++) {
            double distanciaActual = listaNaves.get(i).calcularDistancia(listaCoorDenadasX[ronda],listaCoorDenadaY[ronda]);
            System.out.println("Competidor "+ i + " distancia " +distanciaActual );
            if(distanciaActual<menorDistancia){
                menorDistancia = distanciaActual;
                ganador = i;
            }

        }
        System.out.println("el ganador de esta ronda es "+ ganador);
        return ganador;

    }
    public void ejecutarCompetencia(){
        int[] puntos = new int[listaNaves.size()];

        for (int i = 0; i < listaCoorDenadasX.length; i ++) {
            int ganador = calCularGanadorRonda(i);
            puntos[ganador]++;
        }
        int ganadorTotal=-1;
        int puntajeMaximo =0;
        for (int i = 0; i < listaNaves.size(); i ++) {
            if(puntos[i]>puntajeMaximo){puntajeMaximo = puntos[i];ganadorTotal = i;}
        }
        System.out.println("el ganador de la competencia es " + ganadorTotal);

    }
}
