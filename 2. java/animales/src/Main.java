import clases.Animal;
import clases.Gato;
import clases.Perro;
import clases.Vaca;

public class Main {

    public static void main(String[] args){
        Animal gato = new Gato();
        Animal perro = new Perro();
        Animal vaca = new Vaca();

        System.out.println("¿Qué comen los animales?");
        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);

        System.out.println("¿Qué sonidos emiten los animales?");
        sonidoAnimal(gato);
        sonidoAnimal(perro);
        sonidoAnimal(vaca);

    }

    public static void sonidoAnimal(Animal animal){
        animal.sonido();
    }
    public static void comerAnimal(Animal animal){
        animal.comer();
    }
}
