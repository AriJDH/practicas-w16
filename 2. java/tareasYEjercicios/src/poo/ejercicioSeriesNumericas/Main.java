package poo.ejercicioSeriesNumericas;

public class Main {

    public static void main(String[] args) {

        SerieDos serieDos = new SerieDos();

        System.out.println("Serie 2: ");
        System.out.println(serieDos.valorSiguiente());
        System.out.println(serieDos.valorSiguiente());
        System.out.println(serieDos.valorSiguiente());
        System.out.println(serieDos.valorSiguiente());

        System.out.println("Inicia la serie a partir de 10: ");
        System.out.println(serieDos.setValorInicial(10));
        System.out.println(serieDos.valorSiguiente());
        System.out.println(serieDos.valorSiguiente());
        System.out.println(serieDos.valorSiguiente());

        System.out.println("Reinicia la serie: ");
        System.out.println(serieDos.reiniciarSerie());
        System.out.println(serieDos.valorSiguiente());
        System.out.println(serieDos.valorSiguiente());
        System.out.println(serieDos.valorSiguiente());

        SerieTres serieTres = new SerieTres();
        System.out.println("Serie 3: ");
        System.out.println(serieTres.valorSiguiente());
        System.out.println(serieTres.valorSiguiente());
        System.out.println(serieTres.valorSiguiente());
        System.out.println(serieTres.valorSiguiente());

        System.out.println("Inicia la serie a partir de 12: ");
        System.out.println(serieTres.setValorInicial(12));
        System.out.println(serieTres.valorSiguiente());
        System.out.println(serieTres.valorSiguiente());
        System.out.println(serieTres.valorSiguiente());

        System.out.println("Reinicia la serie: ");
        System.out.println(serieTres.reiniciarSerie());
        System.out.println(serieTres.valorSiguiente());
        System.out.println(serieTres.valorSiguiente());
        System.out.println(serieTres.valorSiguiente());


    }
}
