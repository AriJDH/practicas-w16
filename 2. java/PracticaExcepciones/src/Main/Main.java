package Main;

public class Main {

    public static void main(String[] args) {
        PracticaExcepciones p = new PracticaExcepciones(0, 300);

        try{
            double coc = p.b / p.a;
        }
        catch(Exception e){
            throw new IllegalArgumentException("No se puede dividir por 0");
        }
        finally{
            System.out.println("Programa finalizado");
        }
    }
}
