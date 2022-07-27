public class PracticaExcepcion {


    private int a = 0;
    private int b = 300;


    public void calculate(){
         try{
           int result =  b/a;
         }catch(ArithmeticException e){
             throw new IllegalArgumentException();
         }finally {
             System.out.print("Programa Finalizado");
         }
    }
}
