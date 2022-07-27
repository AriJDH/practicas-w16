package excepciones;

public class PracticaExcepciones {

    int a = 0;
    int b = 300;

    public void calcularCociente(){
        int division = 0;
        try{

            if(a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            division = b/a;

        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones pe = new PracticaExcepciones();
        pe.calcularCociente();
    }
}
