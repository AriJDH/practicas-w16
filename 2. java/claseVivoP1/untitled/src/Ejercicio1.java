public class Ejercicio1 {
    static final int INCENTIVO = 10000;

    public static void main(String[] args) {
        int ventas = 21000;
        int objetivo = 20000;

        if (ventas > objetivo){
            System.out.println("Satisfactorio... +$" + INCENTIVO);
        }
        else{
            System.out.println("No llego al objetivo.");
        }
    }
}
