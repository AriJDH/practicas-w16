package herenciaEncapsulamiento;

public class Main {

    public static void main(String[] args) {

        Animal perro = new Perro("Perro", "Firulais");
        perro.mostrarEspecie();
        perro.hacerSonido();

        System.out.println("----------");

        Gato gato = new Gato("Gato", "Garfield");
        gato.mostrarEspecie();
        gato.hacerSonido();

        System.out.println("----------");

        Animal animal = perro;
        animal.mostrarEspecie();
        animal.hacerSonido();

        System.out.println("----------");

        if(animal == perro){
            System.out.println("VERDADERO");
        }else{
            System.out.println("FALSO");
        }

        System.out.println("----------");

    }

}
