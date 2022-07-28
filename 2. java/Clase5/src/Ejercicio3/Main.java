package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        Gato gato = new Gato();
        Perro perro = new Perro();

        System.out.println(vaca.EmitirSonido());
        System.out.println(vaca.comerHierba());

        System.out.println(gato.EmitirSonido());
        System.out.println(gato.comerCarne());

        System.out.println(perro.EmitirSonido());
        System.out.println(perro.comerCarne());
    }
}
