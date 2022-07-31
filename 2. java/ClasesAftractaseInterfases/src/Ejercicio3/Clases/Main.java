package Ejercicio3.Clases;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        System.out.println("-------------------------");
        vaca.emitirSonidos();
        vaca.comerhierva();
        System.out.println("-------------------------");
        gato.emitirSonidos();
        gato.comerCarne();
        System.out.println("-------------------------");
        perro.emitirSonidos();
        perro.comerCarne();
        System.out.println("-------------------------");

    }
}
