package poo_p2_vivo;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;


    public static void main(String[] args) {
        PracticaExcepciones p = new PracticaExcepciones();
        try{
            if(p.a == 0) throw new IllegalArgumentException("No se puede dividir por cero");
            double division = p.b/p.a;
        }catch(Exception e){
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
