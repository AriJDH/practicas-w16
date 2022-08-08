package practicaExcepciones;

/*
 * Ejercicio > Modulo 5: Java > POO-P2-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
public class PracticaExcepciones {
    public static void main(String[] args){
        int a = 0;
        int b = 300;

        try{
            double cociente = b / a;
            System.out.println("> El resultado de la división es: " + cociente);
        }catch(ArithmeticException ex){
            System.out.println("Se ha producido un error.");
            //throw new IllegalArgumentException("No se puede dividir por cero.");
        }finally{
            System.out.println("Programa finalizado.");
        }
    }
}
