package Condicionales;

public class Main {

    String dni = "12345678"; // dni de ejemplo
    double sueldoBase = 21000; // monto de ejemplo
    double sueldoConAumento;

    public void calcularAumento() {

        // Tu codigo aqui
        if (sueldoBase <= 20000) {
            sueldoConAumento = sueldoBase + (sueldoBase * 20 / 100);
        }
        else {
            if (sueldoBase <= 45000){
                sueldoConAumento = sueldoBase + (sueldoBase * 10 / 100);
            }
            else {
                sueldoConAumento = sueldoBase + (sueldoBase * 5 / 100);
            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }

    public static void main(String[] args) {
        new Main().calcularAumento();
    }

}
