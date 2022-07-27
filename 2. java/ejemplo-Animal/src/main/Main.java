package main;

public class Main {

    public static void main(String[] args){
        Animal animal = new Animal();
        Animal animal1 = new Gato();
        Perro perro = new Perro();


        animal.hacerSonido();
        animal1.hacerSonido();
        perro.hacerSonido();
    }
}
