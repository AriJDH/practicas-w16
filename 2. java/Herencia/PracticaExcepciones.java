package Herencia;

public class PracticaExcepciones {

    static int a = 0 ;
    static int b =300;


    public static int cociente(){
        int cociente = 0;
        try{
            cociente = b/a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir entre cero");
        } finally {
            System.out.println("Programa finalizado");
        }
        return cociente;
    }

    public static void main(String[] args) {
        cociente();
    }
}
