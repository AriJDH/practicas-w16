package Veterinaria;

public abstract class Animal implements ISonido{

    public void hacerSonido(){
        System.out.println("Hace sonido");
    }

    public static void comerAnimal(Animal animal){
        if(animal.getClass() == Gato.class)
            new Gato().comerCarne();
        else if(animal.getClass() == Perro.class)
            new Perro().comerCarne();
        else if(animal.getClass() == Vaca.class)
            new Vaca().comerHierba();
    }
}
