package poo.ejercicioSeriesNumericasV2;

public class Main {

    public static void main(String[] args) {

        SerieDosV2 serieDosV2 = new SerieDosV2();

        System.out.println("Serie 2: ");
        System.out.println(serieDosV2.valorSiguiente());
        System.out.println(serieDosV2.valorSiguiente());
        System.out.println(serieDosV2.valorSiguiente());
        System.out.println(serieDosV2.valorSiguiente());

        System.out.println("Inicia la serie a partir de 20: ");
        serieDosV2.setValorInicial(20);
        System.out.println(serieDosV2.valorSiguiente());
        System.out.println(serieDosV2.valorSiguiente());
        System.out.println(serieDosV2.valorSiguiente());
        System.out.println(serieDosV2.valorSiguiente());

        System.out.println("Reinicia la serie a partir del valor establecido anteriormente: ");
        System.out.println(serieDosV2.reiniciarSerie());
        System.out.println(serieDosV2.valorSiguiente());
        System.out.println(serieDosV2.valorSiguiente());
        System.out.println(serieDosV2.valorSiguiente());


        SerieCincoV2 serieCincoV2 = new SerieCincoV2();

        System.out.println("Serie 5: ");
        System.out.println(serieCincoV2.valorSiguiente());
        System.out.println(serieCincoV2.valorSiguiente());
        System.out.println(serieCincoV2.valorSiguiente());
        System.out.println(serieCincoV2.valorSiguiente());

        System.out.println("Inicia la serie a partir de 17: ");
        serieCincoV2.setValorInicial(17);
        System.out.println(serieCincoV2.valorSiguiente());
        System.out.println(serieCincoV2.valorSiguiente());
        System.out.println(serieCincoV2.valorSiguiente());
        System.out.println(serieCincoV2.valorSiguiente());

        System.out.println("Reinicia la serie a partir del valor establecido anteriormente: ");
        System.out.println(serieCincoV2.reiniciarSerie());
        System.out.println(serieCincoV2.valorSiguiente());
        System.out.println(serieCincoV2.valorSiguiente());
        System.out.println(serieCincoV2.valorSiguiente());
    }
}
