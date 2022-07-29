package practica_1;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;
    double calcularConciente(){

        double res = 0;
        try{
            res = b/a;
        }catch (Exception e){
            System.out.println("Se ha producido un error: "+e.getMessage());
        }
        finally {
            System.out.println("Programa finalizado");
        }
        return res;
    }

    double calcularConciente2(){
        double res = 0;
        try{
            if(a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");
            res = b/a;
        }catch (Exception e){
            System.out.println("Se ha producido un error: "+e.getMessage());
         }
        finally {
            System.out.println("Programa finalizado");
        }
        return res;
    }


}

