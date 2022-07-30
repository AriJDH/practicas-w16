package EjerciciosIntegradoresP1.ClasesAbstractas.executable;

import EjerciciosIntegradoresP1.ClasesAbstractas.actors.*;

public class Main {
    public static void main(String[] args) {
        //First scenario
        Prototype<Integer> serieProgresivaEn2 = new SerieProgresivaEn2<>(2);

        System.out.println(serieProgresivaEn2.nextElement());
        System.out.println(serieProgresivaEn2.nextElement());
        System.out.println(serieProgresivaEn2.nextElement());
        System.out.println(serieProgresivaEn2.nextElement());

        //Second scenario
        Prototype<Number> otraSerieProgresivaEn2 = new SerieProgresivaEn2<>(1);

        System.out.println(otraSerieProgresivaEn2.nextElement());
        System.out.println(otraSerieProgresivaEn2.nextElement());
        System.out.println(otraSerieProgresivaEn2.nextElement());
        System.out.println(otraSerieProgresivaEn2.nextElement());

        //Third scenario
        Prototype<Number> serieProgresivaEn3 = new SerieProgresivaEn3(3);

        System.out.println(serieProgresivaEn3.nextElement());
        System.out.println(serieProgresivaEn3.nextElement());
        System.out.println(serieProgresivaEn3.nextElement());
        System.out.println(serieProgresivaEn3.nextElement());

    }
}
