package clasesAbstractas_Interfaces.ejercicio_3;

public class Main {
    public static void main (String[] args){
        Perro perro = new Perro();
        Vaca vaca = new Vaca();
        Gato gato = new Gato();

        perro.emitirSonido();
        perro.comerCarne();

        gato.emitirSonido();
        gato.comerCarne();

        vaca.emitirSonido();
        vaca.comerHierba();
    }
}
