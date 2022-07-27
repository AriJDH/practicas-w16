package EjercicioUno;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        try{
            if(a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");
            int Calcular = b/a;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }
    }

}
