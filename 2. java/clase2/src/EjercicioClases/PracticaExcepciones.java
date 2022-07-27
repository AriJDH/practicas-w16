package EjercicioClases;

public class PracticaExcepciones {

    public static void main(String[] args) {
        try {
            int a=0;
            int b=300;
            if(a == 0) throw new IllegalArgumentException("No se puede dividir por cero");
            int calculate=b/a;

        }catch (java.lang.Exception e){
            e.printStackTrace();
        }


    }

}
