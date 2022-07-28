package ejercicio3;

public class Main {

    public static void comerAnimal(Animal animal){
        if (animal instanceof Carnivoro)
        {
            ((Carnivoro)animal).comerCarne();
        }
        if(animal instanceof Herviboro){
            ((Herviboro)animal).comerHierva();
        }

    }
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        perro.comerCarne();
        gato.emitirSonido();
        gato.comerCarne();
        vaca.emitirSonido();
        vaca.comerHierva();

        System.out.println("chequeo comerAnimal");
        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }
}
