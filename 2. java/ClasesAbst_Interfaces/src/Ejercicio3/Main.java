package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.emitirSonido();
        gato.comerCarne();
        System.out.println();

        perro.emitirSonido();
        perro.comerCarne();
        System.out.println();

        vaca.emitirSonido();
        vaca.comerHierba();
    }
}
