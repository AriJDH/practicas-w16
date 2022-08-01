package p2vivo;

public class PracticaExcepciones {

    public static void main(String[] args) {

        int a = 0;
        int b = 300;

        try{

            if( a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }else{
                int resultado = b/a;
            }

        }catch (ArithmeticException | IllegalArgumentException exception){
            exception.printStackTrace();
        }finally {
            System.out.println("Programa finalizado");
        }
    }

}
