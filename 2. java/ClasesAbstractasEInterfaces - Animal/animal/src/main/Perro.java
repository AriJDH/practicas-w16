package main;


public class Perro extends Animal implements AlimentacionDeUnCarniboro{
    public Perro() {}
    @Override
    public void hacerSonido(){
        System.out.println("Guau");
    }
    @Override
    public void comerCarne() {
        System.out.printf("Comiendo carne");
    }
}


