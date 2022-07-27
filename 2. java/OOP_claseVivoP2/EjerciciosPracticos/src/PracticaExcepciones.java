public class PracticaExcepciones {
    private int a;
    private int b;

    public PracticaExcepciones(){

    }

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public PracticaExcepciones(int a) {
        this.a = a;
    }

    public double hacerCociente(){
        double aux = 1;

        try {
            aux = this.b/this.a;
        } catch( IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("No se puede dividir por cero.");
        }

        return aux;
    }
}
