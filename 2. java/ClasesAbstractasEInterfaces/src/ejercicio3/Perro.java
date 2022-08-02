package ejercicio3;

public class Perro extends Animal implements Carnivoro{

    public Perro(String sonido,String especie) {
        super(sonido,especie);
    }

    public Perro() {
    }

    @Override
    public void emitirSonido() {
        System.out.println(this.getSonido());
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro está comiendo carne");
    }
}
