package Ejercicio1;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public int calcularCoiciente(int a, int b){
        int resultado = 0;
        try{
            resultado = b/a;
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("programa finalizado");
        }
        return resultado;
    }

    public int calcularCoiciente2(int a, int b){
        int resultado = 0;
        try{
            if (a == 0){
                throw new IllegalArgumentException("No se puede dividir por 0");
            }else {
                resultado = b / a;
            }
            }catch(IllegalArgumentException e){
                e.printStackTrace();
            }finally {
            System.out.println("programa finalizado");
        }
        return resultado;
    }
}
