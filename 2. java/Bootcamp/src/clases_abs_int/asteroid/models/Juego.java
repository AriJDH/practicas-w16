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
        this.agregarAsteroides(true);
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
            if(opcion == 1) this.jugadores.add(this.crearNave(sc));
            else this.jugadores.add(this.crearFlota(sc));
        }
    }

    public boolean esPosicionValida(int value, String eje){
        if(eje.equalsIgnoreCase("x")) return value < 1 || value > this.tamañoMapaX;
        else return value < 0 || value > this.tamañoMapaY;
    }

    public int ingresarPosicionNave(Scanner sc, String eje){
        boolean esX = eje.equalsIgnoreCase("x");
        System.out.printf("Ingresa la posicion en %s [%s-%s]:\n", eje, 1, esX ? this.tamañoMapaX : this.tamañoMapaY);
        int value = sc.nextInt();
        sc.nextLine();
        while(esPosicionValida(value, eje)){
            System.out.printf("Ingresa una posición válida para %s [%s-%s]:\n", eje, 1, esX ? this.tamañoMapaX : this.tamañoMapaY);
            value = sc.nextInt();
            sc.nextLine();
        };
        return value;
    }

    public Nave crearNave(Scanner sc){
        System.out.println("Ingresa el nombre para la nave: ");
        String nombre = sc.nextLine();
        int x = this.ingresarPosicionNave(sc, "x");
        int y = this.ingresarPosicionNave(sc, "y");
        return new Nave(nombre, x, y);
    }

    public FlotaNaves crearFlota(Scanner sc) {
        System.out.println("Creando flota: ");
        System.out.println("Ingrese la cantidad de naves:");
        int cantidadNaves = sc.nextInt();
        sc.nextLine();
        FlotaNaves flota = new FlotaNaves();
        for(int i = 1; i <= cantidadNaves; i++) {
            System.out.printf("Creando nave %s:\n", i);
            flota.agregarNave(crearNave(sc));
        }
        return flota;
    }

    public void agregarAsteroides(boolean verboose) {
        System.out.println("Agregando asteroides ☄️☄️☄️");
        Random ran = new Random();
        for(int i = 0; i < this.cantAsteroides; i++) {
            this.asteroides.add(new Asteroide(ran.nextInt(this.tamañoMapaX) + 1, ran.nextInt(this.tamañoMapaY) + 1) );
            if(verboose) System.out.println(this.asteroides.get(this.asteroides.size() - 1));
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
        System.out.printf("El ganador del juego es %s\n", this.ganador());
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
