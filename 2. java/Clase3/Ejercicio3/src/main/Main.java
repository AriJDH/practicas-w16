package main;

public class Main {
    public static void main(String[] args) {
        ComerAnimales animal=new ComerAnimales();
        animal.animalComiendo("vaca");
        Gato gato=new Gato();
        Perro perro=new Perro();
        Vaca vaca=new Vaca();
        gato.comerCarne();
        gato.sonido();
        perro.comerCarne();
        perro.sonido();
        vaca.sonido();
        vaca.comerHierba();
    }
}
