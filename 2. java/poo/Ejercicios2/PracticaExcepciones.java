package Ejercicios2;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public int calcularCoeficiente(){
        try{
            int resultado;

            if(this.a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }

            resultado = b/a;
            return resultado;

        }catch(IllegalArgumentException | ArithmeticException e){
            e.printStackTrace();
        }finally {
            System.out.println("Programa finalizado");
        }
        return 0;
    }
}
