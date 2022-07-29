package ClasesAbstractasEInterfaces.Ejercicio3;

public class main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        perro.emitirSonido();
        perro.comerCarne();
        perro.comerHierbas();

        gato.emitirSonido();
        gato.comerCarne();
        gato.comerHierbas();

        vaca.emitirSonido();
        vaca.comerCarne();
        vaca.comerHierbas();
    }
}
