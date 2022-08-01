import naves.Nave;
import naves.Nave_simple;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Nave nave1 = new Nave_simple("Nave1",1,2);
        Nave nave2 = new Nave_simple("Nave2",5,4);
        Nave nave3 = new Nave_simple("Nave3",3,2);
        Nave nave4 = new Nave_simple("Nave4",4,4);
        Nave nave5 = new Nave_simple("Nave5",1,5);
        Nave nave6 = new Nave_simple("Nave6",4,2);

        List<Nave> naves1 = new ArrayList<>();
        List<Nave> naves2 = new ArrayList<>();
        List<Nave> naves3 = new ArrayList<>();

        naves1.add(nave1);
        naves2.add(nave2);
        naves2.add(nave3);
        naves2.add(nave4);
        naves3.add(nave5);
        naves3.add(nave6);

        Participante participante1 = new Participante("Erika", naves1);
        Participante participante2 = new Participante("Jessi", naves2);
        Participante participante3 = new Participante("Alicia", naves3);

        List<Participante> participantes = new ArrayList<>();
        participantes.add(participante1);
        participantes.add(participante2);
        participantes.add(participante3);

        Meteorito meteorito = new Meteorito(1,3);
        Meteorito meteorito1 = new Meteorito(2,1);
        Meteorito meteorito2 = new Meteorito(5,3);
        Meteorito meteorito3 = new Meteorito(2,4);
        Meteorito meteorito4 = new Meteorito(1,1);
        Meteorito meteorito5 = new Meteorito(5,3);
        Meteorito meteorito6 = new Meteorito(1,4);
        Meteorito meteorito7 = new Meteorito(2,3);
        Meteorito meteorito8 = new Meteorito(1,4);

        List<Meteorito> meteoritos = new ArrayList<>();
        meteoritos.add(meteorito);
        meteoritos.add(meteorito1);
        meteoritos.add(meteorito2);
        meteoritos.add(meteorito3);
        meteoritos.add(meteorito4);
        meteoritos.add(meteorito5);
        meteoritos.add(meteorito6);
        meteoritos.add(meteorito7);
        meteoritos.add(meteorito8);

        Asteroid asteroid = new Asteroid(participantes, meteoritos);
        asteroid.jugarAsteroid();




    }
}
