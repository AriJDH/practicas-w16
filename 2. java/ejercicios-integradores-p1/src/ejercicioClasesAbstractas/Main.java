package ejercicioClasesAbstractas;

public class Main {
    public static void main(String[] args) {
        GeneradorDeSerie serieDe2 = new GeneradorDeSerieEntero(2);

        System.out.println(serieDe2.siguienteValor()); // imprime 2
        System.out.println(serieDe2.siguienteValor()); // imprime 4
        System.out.println(serieDe2.siguienteValor()); // imprime 6
        System.out.println(serieDe2.siguienteValor()); // imprime 8

        serieDe2.reiniciar();

        serieDe2.establecerValorInicial(1);

        System.out.println(serieDe2.siguienteValor()); // imprime 3
        System.out.println(serieDe2.siguienteValor()); // imprime 5
        System.out.println(serieDe2.siguienteValor()); // imprime 7
        System.out.println(serieDe2.siguienteValor()); // imprime 9

        GeneradorDeSerie serieDe3 = new GeneradorDeSerieEntero(3);

        System.out.println(serieDe3.siguienteValor()); // imprime 3
        System.out.println(serieDe3.siguienteValor()); // imprime 6
        System.out.println(serieDe3.siguienteValor()); // imprime 9
        System.out.println(serieDe3.siguienteValor()); // imprime 12

        /// PRUEBA CON FLOTANTES

        GeneradorDeSerieFlotante serieDe2point5 = new GeneradorDeSerieFlotante(2.5f);

        System.out.println(serieDe2point5.siguienteValor());
        System.out.println(serieDe2point5.siguienteValor());
        System.out.println(serieDe2point5.siguienteValor());
        System.out.println(serieDe2point5.siguienteValor());
    }
}
