public class PracticaExcepciones{
    int a = 0;
    int b = 300;

    public void calcularCocienteP1(){
        try{
            System.out.println(b / a);
        }catch(Exception e){
            System.out.println("Se ha producido un error. "+ e.getMessage());
        }finally{
            System.out.println("Programa finalizado.");
        }
    }

    public void calcularCocienteP2(){
        try{
            System.out.println(b / a);
        }catch(Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero. "+ e.getMessage());
        }finally{
            System.out.println("Programa finalizado.");
        }
    }

    public static void main(String args[]){
        PracticaExcepciones pe = new PracticaExcepciones();

        pe.calcularCocienteP1();
        pe.calcularCocienteP2();
    }

}