public class PracticaExcepciones {
    private int a =0;
    private int b = 300;

    public double cociente(){
        double res = 0;
        try{
            res= b/a;
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }
        return res;
    }
}
