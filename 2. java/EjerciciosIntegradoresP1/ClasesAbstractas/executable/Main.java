package ClasesAbstractas.executable;

import ClasesAbstractas.actors.*;

public class Main {
    public static void main(String[] args) {
        //First scenario
        SerieProgresivaEn2 serieProgresivaEn2 = new SerieProgresivaEn2(2);

        System.out.println(serieProgresivaEn2.nextElement());
        System.out.println(serieProgresivaEn2.nextElement());
        System.out.println(serieProgresivaEn2.nextElement());
        System.out.println(serieProgresivaEn2.nextElement());

        //Second scenario
        SerieProgresivaEn2 otraSerieProgresivaEn2 = new SerieProgresivaEn2(1);

        System.out.println(otraSerieProgresivaEn2.nextElement());
        System.out.println(otraSerieProgresivaEn2.nextElement());
        System.out.println(otraSerieProgresivaEn2.nextElement());
        System.out.println(otraSerieProgresivaEn2.nextElement());

        //Third scenario
        SerieProgresivaEn3 serieProgresivaEn3 = new SerieProgresivaEn3(3);

        System.out.println(serieProgresivaEn3.nextElement());
        System.out.println(serieProgresivaEn3.nextElement());
        System.out.println(serieProgresivaEn3.nextElement());
        System.out.println(serieProgresivaEn3.nextElement());

    }
}
