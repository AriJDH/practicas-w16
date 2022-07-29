package Ejercicio3;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    void emitirSonido(){
        System.out.println("Sonido del animal ");
    }
}
