package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Perro perrito = new Perro("Firulais ");
        Gato gatito = new Gato("Michi ");
        Vaca vaquita = new Vaca("Lola ");

        perrito.emitirSonido();
        perrito.comerCarne();

        gatito.emitirSonido();
        gatito.comerCarne();

        vaquita.emitirSonido();
        vaquita.comerHierba();

        comerAnimal(perrito);
        comerAnimal(gatito);
        comerAnimal(vaquita);
    }

    static void comerAnimal(Animal animal){
        if(animal instanceof Perro) {//instanceof palabra clave que identifica el tipo o la clase
            ((Perro)animal).comerCarne();
        } else if (animal instanceof Gato){
            ((Gato)animal).comerCarne();
        } else {
            ((Vaca)animal).comerHierba();
        }
    }
}
