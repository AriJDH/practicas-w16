package Animal;

public class Main {
    public static void main(String[] args) {

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();
        vaca.comerHierba();
        perro.comerCarne();
        gato.comerCarne();

    }
}
