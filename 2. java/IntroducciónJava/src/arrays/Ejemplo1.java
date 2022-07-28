package arrays;

public class Ejemplo1 {

    // las constantes se definen afuera
    static final int INCENTIVO = 10000;

    public static void main(String[] args) {
        //ESTRUCTURAS CONDICIONALES
        //estructura if ejemplo 1

        int num = 6;

        if (num > 5) {
            System.out.println("El número es mayor que 5");
        } else {
            System.out.println("El número es menor que 5");
        }

        //Si venden x cant ganan un premio, le dice satisfactorio y le dan x plata ejemplo 2

        int ventas = 20000;
        int objetivo = 20000;
        if (ventas > objetivo) {
            System.out.println("Satisfactorio " + INCENTIVO);
        } else {
            System.out.println("No llegó al objetivo");
        }

        //estructura if-else

        int hour = 21;

        if (hour >= 6 && hour < 12) {
            System.out.println("Buenos días");
        } else {
            if (hour >= 12 && hour < 19) {
                System.out.println("Buenas tardes");
            } else {
                System.out.println("Buenos noches");
            }
        }
        //  Estructura Switch

        int typeResult = 2;
        String message;

        switch (typeResult) {
            case 1:
                message = "Primer Puesto";
                break;
            case 2:
                message = "Segundo Puesto";
                break;
            case 3:
                message = "Tercer Puesto";
                break;
            default:
                message = "Gracias por participar";
        }
        System.out.println(message);


        //ESTRUCTURAS REPETITIVAS

        //do while, la condicion se evalua al final del bloque

        int number = 3;
        do {
            System.out.println("El valor es DO WHILE: " + number);
        } while (number < 2);

        //while

        int x = 1;

        while (x <= 4) {
            System.out.println("El valor es WHILE: " + x);
            x++;
        }

        //for controlada por contador

        for (int i = 2; i < 5; i++) {
            System.out.println("El valor de i: " + i);
        }
    }

}
