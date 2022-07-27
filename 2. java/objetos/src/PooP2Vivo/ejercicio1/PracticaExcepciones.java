package PooP2Vivo.ejercicio1;

public class PracticaExcepciones {

    int a = 0;
    int b = 300;

    public double calcularCociente (){
        try{
            return b/a;
        }catch (ArithmeticException e){
            //System.out.println("No se ejecuto la cuenta, "+e.getMessage());
            throw new IllegalArgumentException("No se puede dividir entre 0");
        }finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones pe = new PracticaExcepciones();

        pe.calcularCociente();
    }
}
