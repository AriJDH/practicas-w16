package integrador.series_numericas;

import integrador.series_numericas.model.Serie1;
import integrador.series_numericas.model.Serie2;
import integrador.series_numericas.model.Serie3;

public class Main {
    public static void main(String[] args) {
        final int cantidad = 4;

        Serie2 serie2 = new Serie2();
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("%s" + (i==cantidad-1 ? "\n" : ", "), serie2.siguiente());
        }

        Serie1 serie1 = new Serie1();
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("%s" + (i==cantidad-1 ? "\n" : ", "), serie1.siguiente());
        }

        Serie3 serie3 = new Serie3();
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("%s" + (i==cantidad-1 ? "\n" : ", "), serie3.siguiente());
        }

    }
}
