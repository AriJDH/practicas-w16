package integrador.series_numericas;

import integrador.series_numericas.model.Serie1;
import integrador.series_numericas.model.Serie2;
import integrador.series_numericas.model.Serie3;

public class Main {
    public static void main(String[] args) {
        Serie2 serie2 = new Serie2();
        for (int i = 0; i < 4; i++) {
            System.out.println(serie2.siguiente());
        }

        Serie1 serie1 = new Serie1();
        for (int i = 0; i < 4; i++) {
            System.out.println(serie1.siguiente());
        }

        Serie3 serie3 = new Serie3();
        for (int i = 0; i < 4; i++) {
            System.out.println(serie3.siguiente());
        }

    }
}
