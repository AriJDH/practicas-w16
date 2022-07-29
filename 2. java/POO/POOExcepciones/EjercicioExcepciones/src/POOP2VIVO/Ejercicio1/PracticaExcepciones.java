package POOP2VIVO.Ejercicio1;

public class PracticaExcepciones {
    private int a=0;
    private int b=200;
    private double resultado;

    void cosiente(){

        try{
            if(a==0){
                throw new ArithmeticException("No se puede dividir por cero");
            }
            System.out.println("El resultado es: " + resultado);
            resultado=b/a;
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());

        }finally {
            System.out.println("Programa finalizado");

        }



    }

}
