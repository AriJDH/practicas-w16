package Ejercicios3;

public class Main {
    public static void main(String[] args) {
        /*
        Como propuesta extra se sugiere llamar a un método comerAnimal donde a partir del pasaje de un objeto de cualquier tipo de animal como parámetro, invoque al método para comer según corresponda a dicho animal.
         */
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();
        Animal animal = new Perro();

        System.out.println("sonidoos------");
        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        System.out.println("comer-------");
        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();

        System.out.println("prueba comerAnimal------");
        perro.comerAnimal(perro.getEsCarnivoro());
        gato.comerAnimal(gato.getEsCarnivoro());
        vaca.comerAnimal(vaca.getEsCarnivoro());

    }
}
