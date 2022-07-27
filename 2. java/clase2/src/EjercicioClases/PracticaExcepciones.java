package EjercicioClases;

public class PracticaExcepciones {

    public static void main(String[] args) {
        try {
            int a=0;
            int b=300;
            int calculate=b/a;
        }catch (ArithmeticException e){
            System.out.println("no se puede divir por cero");

        }


    }

}
