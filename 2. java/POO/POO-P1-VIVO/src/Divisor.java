public class Divisor {
    public static void main(String[] args) {
        System.out.println("Antes de hacer la división");
        try{
            double division = 100/0;

        }catch (ArithmeticException e){
            System.out.println("Error al dividir por cero " + e.getMessage());
        }
        finally {
            System.out.println("Finally se ejecuta si o si");
        }
    }
}
