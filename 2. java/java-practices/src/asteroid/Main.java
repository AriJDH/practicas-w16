package asteroid;

import java.util.Arrays;

/*
 * Ejercicio > Modulo 5: Java > MaterialComplementarioClasesAbstractasEInterfaces
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
public class Main {
    public static void main(String[] args) {
        // A TENER EN CUENTA:
        // - El juego se desarrollará tomando el Primer Cuadrante del plano (X,Y siempre positivos).
        // - El escenario en el cual se llevará a cabo el juego es de 10x10.

        // Participante 1
        Participante gonzalo = new Participante("Gonzalo Nahuel", "Di Pierro", new Nave("Machine Empire", new Coordenada(5,6)));

        // Participante 2
        Participante juan = new Participante("Juan", "Perez", new FlotaDeNaves(Arrays.asList(
                new Nave("USS Enterprise", new Coordenada(1,4)),
                new Nave("Elysium", new Coordenada(1,6))
        )));

        Asteroid asteroid = new Asteroid(Arrays.asList(gonzalo, juan));
        asteroid.iniciarJuego(Arrays.asList(  // Inicio del juego
                new Coordenada(1,5),
                new Coordenada(5,5),
                new Coordenada(5,7)
        ));
    }
}
