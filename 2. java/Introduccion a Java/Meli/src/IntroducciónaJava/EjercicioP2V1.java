package IntroducciónaJava;

public class EjercicioP2V1 {
    public class Main {

        String dni = "12345678"; // dni de ejemplo
        double sueldoBase = 21000; // monto de ejemplo
        double sueldoConAumento;

        public void calcularAumento() {

            // Tu codigo aqui
            // Tu codigo aqui
            if (sueldoBase<=20000) {
                sueldoConAumento=sueldoBase+(sueldoBase*0.2);
                System.out.println ("corresponde aumento del 20%");

            }
            else {
                if (sueldoBase > 20000 && sueldoBase <= 45000){
                    sueldoConAumento=sueldoBase+(sueldoBase*0.1);
                    System.out.println ("corresponde aumento del 10%");
                }
                else {
                    sueldoConAumento=sueldoBase+(sueldoBase*0.05);
                    System.out.println ("corresponde aumento del 5%");
                }
            }

            System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
        }


    }
}
