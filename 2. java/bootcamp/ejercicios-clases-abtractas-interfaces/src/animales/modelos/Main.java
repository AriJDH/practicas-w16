package animales.modelos;

public class Main {

    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.comerCarne();
        perro.emitirSonido();

        System.out.println();

        Gato gato = new Gato();
        gato.comerCarne();
        gato.emitirSonido();

        System.out.println();
        Vaca vaca = new Vaca();
        vaca.comerHierba();
        vaca.emitirSonido();
    }
}
