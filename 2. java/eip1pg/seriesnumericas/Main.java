package eip1pg.seriesnumericas;

public class Main {
    public static void main(String[] args) {

    SerieDos serie2 = new SerieDos(0,2);
        System.out.println("Serie 2");
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());

        //Establecer valor inicial 1
        serie2.setValorInicial(1);
        System.out.println("Inicio en 1");
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());

        //reiniciar serie
        serie2.reiniciarSerie();
        System.out.println("Reinicio de serie");
        System.out.println(serie2.getValorInicial());
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());


        System.out.println("Serie 3");
        SerieDos serie3 = new SerieDos(0,3);
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());

        //Establecer valor inicial 1
        serie3.setValorInicial(1);
        System.out.println("Inicia en 1");
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());

        //reiniciar serie
        serie3.reiniciarSerie();
        System.out.println("Reinicio de serie");
        System.out.println(serie3.getValorInicial());
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());

    }
}
