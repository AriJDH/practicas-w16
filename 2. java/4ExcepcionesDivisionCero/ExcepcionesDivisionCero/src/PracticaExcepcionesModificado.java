package ejercicioDivisionCeroExcepciones;

public class PracticaExcepcionesModificado {
    public static void main(String[] args) {

        //Ejercicio1 punto 2
        int a = 0;
        int b = 300;

        try {

            if (a==0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int conciente2 = b / a;

        } catch (IllegalArgumentException | ArithmeticException  e) {
            System.out.println(e.getMessage());
        }  finally {
            System.out.println("Programa finalizado");
        }

    }
}
