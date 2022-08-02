package ejercicio3;

public class Vaca extends Animal implements Herviboro{

    public Vaca(String sonido, String especie) {
        super(sonido, especie);
    }

    public Vaca() {
    }

    @Override
    public void emitirSonido() {
        System.out.println(this.getSonido());
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca está comiendo hierba");
    }
}
