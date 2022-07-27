package PracticaExcepciones;

public class Main {
    static int a=0;
    static int b=300;

    public static void main(String[] args) {
        try{
            float cociente = b/a;
        } catch (RuntimeException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa Finalizado");
        }
    }

}
