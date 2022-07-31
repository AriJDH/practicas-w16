package animales.clases;

public class Main {

    public static void main(String[] args){

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();

        System.out.println("------------------------------");

        perro.comerAnimal(perro);
        gato.comerAnimal(gato);
        vaca.comerAnimal(vaca);
    }
}
