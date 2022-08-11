package clases_abs_int.animales.models;

public class Animal {
    protected Tipo tipo;

    public Animal(Tipo tipo) {
        this.tipo = tipo;
    }

    public void emitirSonido(){}

    public void comer(Animal animal){
        if (this.tipo.equals(Tipo.CARNIVORO)) System.out.println("Se lo puede comer 🍔.");
        else if (this.tipo.equals(Tipo.HERVIBORO)) System.out.println("No se lo puede comer ❌.");
    }
}
