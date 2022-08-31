package seriesNumericas;

public class Main {

    public static void main(String[] args) {
        System.out.println("SERIE NUMÉRICA DE 2:");
        generarSerieNumericaDeDos();

        System.out.println();

        System.out.println("SERIE NUMÉRICA DE 3:");
        generarSerieNumericaDeTres();
    }

    private static void generarSerieNumericaDeDos() {
        System.out.println("> Inicia la serie númerica de 2 con valor inicial en 0.");
        Prototipo<Integer> serieDeDos = new SerieDos(0);
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());

        System.out.println("> Se setea el valor inicial en 1 y se reinicia la serie.");
        serieDeDos.valorInicial(1);
        serieDeDos.reiniciarSerie();
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());

        System.out.println("> Se reinicia la serie nuevamente.");
        serieDeDos.valorInicial(0);
        serieDeDos.reiniciarSerie();
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
        System.out.println(serieDeDos.siguienteValor());
    }

    private static void generarSerieNumericaDeTres() {
        System.out.println("> Inicia la serie númerica de 3 con valor inicial en 1");
        Prototipo<Integer> serieDeTres = new SerieTres(1);
        System.out.println(serieDeTres.siguienteValor());
        System.out.println(serieDeTres.siguienteValor());
        System.out.println(serieDeTres.siguienteValor());
        System.out.println(serieDeTres.siguienteValor());
        System.out.println(serieDeTres.siguienteValor());

        System.out.println("> Se setea el valor inicial en 0 y se reinicia la serie.");
        serieDeTres.valorInicial(0);
        serieDeTres.reiniciarSerie();
        System.out.println(serieDeTres.siguienteValor());
        System.out.println(serieDeTres.siguienteValor());
        System.out.println(serieDeTres.siguienteValor());
        System.out.println(serieDeTres.siguienteValor());
        System.out.println(serieDeTres.siguienteValor());
    }

}
