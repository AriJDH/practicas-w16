package Ejercicios5;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.DoubleStream;

public class Asteroid {
    private List<Participante> participantes;
    private List<Meteorito> meteoritos;

    public Asteroid(List<Participante> participantes, List<Meteorito> meteoritos) {
        this.participantes = participantes;
        this.meteoritos = meteoritos;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void ganador(){
        //paso los array de cordenadas a arrays d distancias
        var distanciaMeteoritos = meteoritos.stream().mapToDouble(Meteorito::coordenadaADistancia);

        var arrayDistaciaNaves = participantes.stream().mapToDouble(participante -> {
            if(participante.getNave() != null) {
                return participante.getNave().coordenadaADistancia();
            } else{
                return participante.getFlotaNaves().coordenadaADistancia();
            }
        });

        try{
            //comparo las distancias de los meteoritos con las de las naves para ver la nave mas cercana a cada meteorito
            distanciaMeteoritos.forEach(distanciaMeteorito -> {
                final double[] result = {100.0};
                final int[] index = {0};
                final int[] contador = {-1};

                arrayDistaciaNaves.forEach(nave -> {
                    var resta = distanciaMeteorito - nave;
                    contador[0] += 1;

                    if(resta < result[0]){
                        result[0] = resta;
                        index[0] = contador[0];
                    }
                });

                System.out.println("el ganador es " + participantes.get(index[0]).getNombre());
                participantes.get(index[0]).getNave().setPuntuacion(participantes.get(index[0]).getNave().getPuntuacion() + 1);
            });

        }catch (Exception e){
            System.out.println(e);
        }


    }

}
