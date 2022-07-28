package Estructuras;

public class Ejercicio_sueldos {

        String dni = "12345678"; // dni de ejemplo
        double sueldoBase = 50000; // monto de ejemplo
        double sueldoConAumento;

        public void calcularAumento() {

            // Tu codigo aqui

            if (sueldoBase <= 20000) {
                sueldoConAumento = sueldoBase + (sueldoBase*0.20);
            }
            else {
                if (sueldoBase>20000 && sueldoBase<=45000){
                    sueldoConAumento = sueldoBase + (sueldoBase*0.10);
                }
		  else {
                    sueldoConAumento = sueldoBase + (sueldoBase*0.05);
                }
            }

            System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
        }

        public static void main(String[] args) {
            new Ejercicio_sueldos().calcularAumento();
        }

    }


