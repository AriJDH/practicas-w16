package Julio27;

public class PracticaExcepciones {

    public static void main(String[] args) {
        //version 1
        int a = 0;
        int b = 300;
        try{
            int c = b/a;
        }catch(ArithmeticException e) {
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }
        //version 2
        int a2 = 0;
        int b2 = 300;
        try{
            if(a2 == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }else{
                int c2 = b/a;
            }

        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
