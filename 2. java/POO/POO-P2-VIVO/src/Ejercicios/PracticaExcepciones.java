package Ejercicios;

public class PracticaExcepciones {

    public static void main(String[] args) {
        int a=0;
        int b=300;
        //int cociente;
        /*try{
            cociente = b/a;
        }
        catch(ArithmeticException e){
            System.out.println("Se ha producido un error");
        }
        finally{
            System.out.println("Programa finalizado");
        }*/

        try{
            if(a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }

}
