package Ejercicio1;

public class POOP2 {
    public static int a = 0;
    public static int b = 300;
    public static void main(String[] args) {
        calcular();
    }
        public static void calcular() {
            try {
                int calculo = b / a;
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException("No se puede dividir entre 0");
            } finally {
                System.out.println("Programa Finalizado");
            }
        }

}
