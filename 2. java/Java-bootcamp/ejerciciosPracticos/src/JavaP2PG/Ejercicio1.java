package JavaP2PG;

public class Ejercicio1 {

    String dni = "12345678"; // dni de ejemplo
    double sueldoBase = 21000; // monto de ejemplo
    double sueldoConAumento;
    double sueldoA = 20000;
    double sueldoB = 45000;

    public void calcularAumento() {

        // Tu codigo aqui
        if (sueldoBase <= sueldoA) {
            sueldoConAumento = sueldoBase * 1.2;
        } else {
            if (sueldoBase > sueldoA && sueldoBase <= sueldoB) {
                sueldoConAumento = sueldoBase * 1.1;
                sueldoConAumento = Math.round(sueldoConAumento);
            } else {
                sueldoConAumento = sueldoBase * 1.05;
            }
        }

        System.out.println("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }

    public static void main(String[] args) {
        new Ejercicio1().calcularAumento();
    }
}
