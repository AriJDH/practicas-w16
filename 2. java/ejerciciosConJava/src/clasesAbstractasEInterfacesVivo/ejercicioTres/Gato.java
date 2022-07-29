package clasesAbstractasEInterfacesVivo.ejercicioTres;

public class Gato extends Animal implements Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("miua miau miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato esta comiendo carne");
    }
}
