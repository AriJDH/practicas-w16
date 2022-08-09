public class PracticaExcepciones {
    int a = 0;
    int b = 300;
    void calcular() {
        try {
            if(this.a == 0) {
                throw new IllegalArgumentException("No se puede dividir por 0");
            }
            System.out.println(this.b / this.a);
        } catch (ArithmeticException error)  {
            System.out.println("Se ha producido un error");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}
