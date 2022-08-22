package seriesNumericas;

/*
 * Ejercicio > Modulo 5: Java > EjerciciosIntegradores-P1-PG
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
public class Main {
    public static void main(String[] args) {
        System.out.println("SERIE NUMÉRICA DE 2:");
        generarSerieNumericaDeDos();

        System.out.println();

        System.out.println("SERIE NUMÉRICA DE 3:");
        generarSerieNumericaDeTres();
    }

    public static void generarSerieNumericaDeDos() {
        System.out.println("> Inicia la serie númerica de 2 con valor inicial en 0.");
        Prototipo<Integer> serieDeDos = new SerieNumericaDeDos<Integer>(0);
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());

        System.out.println("> Se setea el valor inicial en 1 y se reinicia la serie.");
        serieDeDos.setValorInicial(1);
        serieDeDos.reiniciar();
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());

        System.out.println("> Se reinicia la serie nuevamente.");
        serieDeDos.reiniciar();
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
    }

    public static void generarSerieNumericaDeTres() {
        System.out.println("> Inicia la serie númerica de 3 con valor inicial en 5.");
        Prototipo<Double> serieDeTres = new SerieNumericaDeTres<Double>(5.0);
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());

        System.out.println("> Se setea el valor inicial en 0 y se reinicia la serie.");
        serieDeTres.setValorInicial(0.0);
        serieDeTres.reiniciar();
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());

        System.out.println("> Se reinicia la serie nuevamente.");
        serieDeTres.reiniciar();
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
        System.out.println(serieDeTres.siguiente());
    }
}
