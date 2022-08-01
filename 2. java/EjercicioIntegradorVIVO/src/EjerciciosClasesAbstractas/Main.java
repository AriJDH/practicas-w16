package EjerciciosClasesAbstractas;

public class Main {
    private static Integer valorActual;
    private static Integer valorInicial;

    public static void main(String[] args) {
        Serie serie = new Serie();
        serie.establecerValorInicialSerie(2);
        Integer v1 = serie.siguienteValorSerieProgresiva(3);
        System.out.println("Siguiente valor de serie progresiva: " + v1);

        Integer v2 = serie.siguienteValorSerieProgresiva(3);
        System.out.println("Siguiente valor de serie progresiva: " + v2);

        Integer v3 = serie.siguienteValorSerieProgresiva(3);
        System.out.println("Siguiente valor de serie progresiva: " + v3);

        Integer v4 = serie.siguienteValorSerieProgresiva(3);
        System.out.println("Siguiente valor de serie progresiva: " + v4);

        serie.reiniciar();
        Integer v5 = serie.siguienteValorSerieProgresiva(3);
        System.out.println("Siguiente valor de serie progresiva: " + v5);


    }
}
