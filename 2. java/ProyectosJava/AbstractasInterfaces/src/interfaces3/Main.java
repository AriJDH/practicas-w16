package abstractasInterfases.interfaces3;

public class Main {

    public static void comerAnimal(Animal animal){

        if (animal instanceof Herbivoro){
            ((Herbivoro) animal).comerHierba();
        } else if (animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
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
        vaca.comerHierba();

        System.out.println("\n\n\n");

        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);


    }
}
