package main;

public class Gato extends Animal implements AlimentacionDeUnCarniboro{
    public Gato() {}
    @Override
    public void hacerSonido(){
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.printf("Comiendo carne");
    }
}

