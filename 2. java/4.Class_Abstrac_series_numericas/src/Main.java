public class Main {
    public static void main(String[] args) {
        Serie2 serie2 = new Serie2();

        System.out.println(serie2.valorSiguienteSerie());
        System.out.println(serie2.valorSiguienteSerie());
        System.out.println(serie2.valorSiguienteSerie());
        System.out.println(serie2.valorSiguienteSerie());
        System.out.println("*************************\n");

        serie2.valorinicialSerie(1);
        System.out.println(serie2.valorSiguienteSerie());
        System.out.println(serie2.valorSiguienteSerie());
        System.out.println(serie2.valorSiguienteSerie());
        System.out.println(serie2.valorSiguienteSerie());
        System.out.println("*************************\n");

        Serie3 serie3 = new Serie3();
        //serie3.valorinicialSerie(3);

        System.out.println(serie3.valorSiguienteSerie());
        System.out.println(serie3.valorSiguienteSerie());
        System.out.println(serie3.valorSiguienteSerie());
        System.out.println(serie3.valorSiguienteSerie());
    }
}
