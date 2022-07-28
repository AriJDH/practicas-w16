package main;

public class Main {
    public static void main(String[] args){
        Vaca unaVaca = new Vaca();
        Gato unGato = new Gato();
        Perro unPerro = new Perro();

        System.out.println("Sonido de vaca: ");
        unaVaca.hacerSonido();
        System.out.println("La vaca esta: ");
        unaVaca.comerHierba();

        System.out.println('\n');

        System.out.println("Sonido de gato: ");
        unGato.hacerSonido();
        System.out.println("El gato esta: ");
        unGato.comerCarne();

        System.out.println('\n');

        System.out.println("Sonido de perro: ");
        unPerro.hacerSonido();
        System.out.println("El perro esta: ");
        unPerro.comerCarne();
    }
}
