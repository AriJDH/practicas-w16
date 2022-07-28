package ClasesAbstractas_Interfaces.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();
        System.out.println("-------------------");
        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();
        System.out.println("-------------------");
        perro.comerAnimal(gato);
        gato.comerAnimal(perro);
        vaca.comerAnimal(gato);
    }
}
