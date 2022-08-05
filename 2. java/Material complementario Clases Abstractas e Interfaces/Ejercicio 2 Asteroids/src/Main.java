import naves.Coordenada;
import naves.FlotaNaves;
import naves.Nave;
import naves.NaveSimple;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Nave nave1 = new NaveSimple("Nave1", new Coordenada(5,5));
        Nave nave2 = new NaveSimple("Nave2",new Coordenada(1,2));
        Nave nave3 = new NaveSimple("Nave3",new Coordenada(3,2));

        List<Nave> naves1 = new ArrayList<>();

        naves1.add(nave2);
        naves1.add(nave3);

        Participante participante1 = new Participante("Erika", nave1);
        Participante participante2 = new Participante("Jessi", new FlotaNaves(naves1));

        List<Participante> participantes = new ArrayList<>();
        participantes.add(participante1);
        participantes.add(participante2);

        Meteorito meteorito = new Meteorito(5,4);
        Meteorito meteorito1 = new Meteorito(5,5);
        Meteorito meteorito2 = new Meteorito(3,2);

        List<Meteorito> meteoritos = new ArrayList<>();
        meteoritos.add(meteorito);
        meteoritos.add(meteorito1);
        meteoritos.add(meteorito2);

        Asteroid asteroid = new Asteroid(participantes, meteoritos);
        asteroid.jugarAsteroid();




    }
}
