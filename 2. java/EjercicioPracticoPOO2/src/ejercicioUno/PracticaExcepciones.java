package ejercicioUno;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a=0;
        int b=300;

        try{
            if (a==0) {
                throw new IllegalArgumentException("No se puede dividir por 0");
            }
            int resultado=b/a;

        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }finally {
            System.out.println("Programa Finalizado");
        }

        try{
            int resultado=b/a;
        }catch(ArithmeticException e){
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa Finalizado");
        }

    }
}
