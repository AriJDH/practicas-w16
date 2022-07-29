package clasesAbstractasEInterfacesVivo.ejercicioTres;

public class Main {
    public static void main(String[] args) {

        Perro perro = new Perro();
        System.out.println("-------Perro---------");
        perro.emitirSonido();
        perro.comerCarne();

        System.out.println("---------Gato----------");
        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();

        System.out.println("--------Vaca--------");
        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();
    }
}
