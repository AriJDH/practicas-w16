public class AumentoSueldos {

        String dni = "12345678"; // dni de ejemplo
        double sueldoBase = 25000; // monto de ejemplo
        double sueldoConAumento;

        public void calcularAumento() {

            // Tu codigo aqui
            if (sueldoBase <= 20000) {
                sueldoConAumento = sueldoBase + (sueldoBase * 20/100);
                System.out.println("le corresponde un 20% de aumento.");
            }
            else {
                if (sueldoBase > 20000 && sueldoBase <= 45000){
                    sueldoConAumento = sueldoBase + (sueldoBase * 10/100);
                    System.out.println("le corresponde un 10% de aumento.");
                }
                else {
                    sueldoConAumento = sueldoBase + (sueldoBase * 5/100);

                    System.out.println("le corresponde un 5% de aumento.");
                }
            }

            System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
        }

        public static void main(String[] args) {
            new AumentoSueldos().calcularAumento();
        }


}
