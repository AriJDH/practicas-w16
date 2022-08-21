package JavaAbstractInterfaceVIVO.ejercicio3;

public class Main {

    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.producirSonido();

        Gato gato = new Gato();
        gato.producirSonido();

        Animales vaca = new Vaca();
        vaca.producirSonido();

        System.out.println();

        perro.comerAnimal(perro);
        gato.comerAnimal(gato);
    }
}
