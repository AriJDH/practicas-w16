package practices;

public class ExerciseSalary {

    String dni = "12345678";
    double sueldoBase = 21000;
    double sueldoConAumento;

    public void calcularAumento() {

        if (sueldoBase <= 20000) {
            sueldoConAumento = sueldoBase + (sueldoBase*0.20);
        }
        else {
            if (sueldoBase > 20000 && sueldoBase <= 45000){
                sueldoConAumento = sueldoBase + (sueldoBase*0.10);
            }
            else {
                sueldoConAumento = sueldoBase + (sueldoBase*0.05);
            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }

    public static void main(String[] args) {
        new ExerciseSalary().calcularAumento();
    }
}
