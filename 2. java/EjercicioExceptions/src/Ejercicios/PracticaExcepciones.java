package Ejercicios;

public class PracticaExcepciones {
    static int a = 0;
    static int b = 300;

    public static void main(String[] args){
        try{
            //double cociente = b/a;
            if (a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");

        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        finally{
            System.out.println("Programa finalizado");
        }
    }
}
