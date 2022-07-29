package clases_abs_int.asteroid.models;

import clases_abs_int.asteroid.interfaces.ILogicaNave;

import java.util.*;

public class Juego {
    private int cantAsteroides;
    private int cantJugadores;
    private int tamañoMapaX;
    private int tamañoMapaY;
    List<ILogicaNave> jugadores;
    List<Asteroide> asteroides;

    public Juego(int cantAsteroides, int cantJugadores, int tamañoMapaX, int tamañoMapaY) {
        this.cantAsteroides = cantAsteroides;
        this.cantJugadores = cantJugadores;
        this.tamañoMapaX = tamañoMapaX;
        this.tamañoMapaY = tamañoMapaY;

        this.jugadores = new ArrayList<>();
        this.asteroides = new ArrayList<>();

        this.agregarJugadores();
        this.agregarAsteroides();
    }

    private void mostrarMenuJugadores(){
        System.out.println("1. Agregar nave 🚀");
        System.out.println("2. Agregar flota 🚀🚀🚀");
    }

    public void agregarJugadores() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.cantJugadores; i++) {
            int opcion = 0;
            do{
                this.mostrarMenuJugadores();
                opcion = sc.nextInt();
                sc.nextLine();
            }while (opcion != 1 && opcion != 2);
            if(opcion == 1) this.jugadores.add(new Nave());
            else this.jugadores.add(new FlotaNaves());
        }
    }

    public void agregarAsteroides() {
        System.out.println("Agregando asteroides ☄️☄️☄️");
        Random ran = new Random();
        for(int i = 0; i < this.cantAsteroides; i++) {
            this.asteroides.add(new Asteroide(ran.nextInt(this.tamañoMapaX), ran.nextInt(this.tamañoMapaY)));
        }
    }

    public void jugar(){
        for(Asteroide asteroide : this.asteroides){
            ILogicaNave ganador = this.getGanadorRonda(asteroide);
            ganador.incrementarMarcador();
            System.out.println("-------------------------------------------------------");
            System.out.printf("El ganador de la ronda es 🥳:\n %s\n", ganador);
            System.out.println("-------------------------------------------------------");
        }
        System.out.println("✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨");
        System.out.printf("El ganador del juego es %s.\n", this.ganador());
        System.out.println("✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨");
    }

    public ILogicaNave getGanadorRonda(Asteroide asteroide){
        return this.jugadores.stream()
                .min(Comparator.comparing(nave -> nave.calcularDistancia(asteroide.getX(), asteroide.getY())))
                .get();
    }

    public ILogicaNave ganador(){
        return this.jugadores.stream()
                .max(Comparator.comparing(ILogicaNave::getMarcador))
                .get();
    }
}
