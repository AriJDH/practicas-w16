package EjercicioUno;

public class PracticalExceptions {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        if (a == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } else {
            int calculo = b/a;
        }
    }

    public void primerEjercicio() {
        try {
            int a = 0;
            int b = 300;
            int calculo = b/a;
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
