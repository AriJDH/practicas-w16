package Asteroid.executable;

import Asteroid.space.characters.*;
import Asteroid.space.scene.Space;
import Asteroid.space.targets.Asteroide;

public class Main {
    public static void main(String[] args) {
        Space space = new Space();
        space.addPlayer("player1", new NaveSimple(0, 0));
        space.addPlayer("player2", new NaveSimple(0, 10));

        Flota flota = new Flota();
        flota.addNave(new NaveSimple(15, 12));
        flota.addNave(new NaveSimple(15, 13));
        flota.addNave(new NaveSimple(15, 14));

        space.addPlayer("player3", flota);

        space.addAsteroid(new Asteroide(10, 11));

        space.run();
    }
}
