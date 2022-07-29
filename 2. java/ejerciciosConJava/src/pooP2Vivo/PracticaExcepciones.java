package pooP2Vivo;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a=0;
        int b=300;

        try{
            if(a==0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int cociente=a/b;
        }catch(IllegalArgumentException exception){
            exception.printStackTrace();

            //System.out.println("Se ha producido una excepción");
        }finally{
            System.out.println("Programa finalizado");
        }

    }

}
