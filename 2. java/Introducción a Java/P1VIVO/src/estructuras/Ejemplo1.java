package estructuras;

public class Ejemplo1 {
    static final int INCENTIVO = 10000;

    public static void main(String[] args) {
        int ventas = 23000;
        int objetivo = 20000;

        if(ventas > objetivo){
            System.out.println("Satisfactorio, ganaste un incentivo de $" + INCENTIVO + ".");
        }else{
            System.out.println("No llegó al objetivo de $" + objetivo + " en ventas.");
        }
    }

}

