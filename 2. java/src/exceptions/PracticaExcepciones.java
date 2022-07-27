package exceptions;

public class PracticaExcepciones {

    public static void main(String[]args) throws Exception {
        int a = 0, b=300;

        try{
            double division = b/a;
        } catch (ArithmeticException e){
//            System.out.println(e.getStackTrace());
//            System.out.println(e.getCause());
//            System.out.println(e.getMessage());
//            System.out.println(e);

            IllegalArgumentException ia = new IllegalArgumentException();
            throw new Exception("Se ha producio un error",ia);

        } finally {
            System.out.println("Programa finalizado");
        }

    }
}
