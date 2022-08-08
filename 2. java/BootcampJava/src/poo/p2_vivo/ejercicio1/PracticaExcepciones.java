package poo.p2_vivo.ejercicio1;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try{
            double cociente= b/a;
            System.out.println("El cociente entre los numeros ingresados es: " + cociente);
        } catch (ArithmeticException ex) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado" );
        }

        ///Segunda condicion

        try{
            if (a==0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            } else {
                double cociente = b/a;
                System.out.println("El cociente entre los numeros ingresados es: " + cociente);
            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Programa finalizado" );
        }
    }
}

