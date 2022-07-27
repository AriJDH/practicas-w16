package estructuras;

public class Ejemplo1 {
    static final int INCENTIVO=1000;
    public static void main(String[] args) {
        int ventas=21000;
        int objetivo=20000;
        if (ventas>objetivo){
            System.out.println("sastisfactoria"+ INCENTIVO);
        }else {
            System.out.println("No llego a el incentivo"+ INCENTIVO);

        }
    }
}
