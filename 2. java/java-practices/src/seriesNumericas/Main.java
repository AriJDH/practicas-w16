package seriesNumericas;

/*
 * Ejercicio > Modulo 5: Java > EjerciciosIntegradores-P1-PG
 * ESTADO: Finalizado (falta revisión y emprolijar).
 * @GonzaloNahuelDiPierro
 * */
public class Main {
    public static void main(String[] args) {
        Prototipo<Integer> serie = new SerieNumericaDeDos<Integer>(2);
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());

        serie.reiniciar();

        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
    }
}
