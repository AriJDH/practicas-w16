package EstructurasDeControlYArreglos;



public class CalcularAumento {

    String dni = "12345678"; // dni de ejemplo
    double sueldoBase = 21000; // monto de ejemplo
    double sueldoConAumento;

        //    a) Si el sueldo es menor o igual a $20.000 le corresponde un 20% de aumento.
        //    b) Si el sueldo es mayor a $20.000 pero menor o igual a $45.000 le corresponde un 10% de aumento.
        //    c) Si el sueldo es mayor a $45.000 le corresponde un 5% de aumento

    public void calcularAumento() {

       if (sueldoBase<=20000){
           sueldoConAumento = sueldoBase + ((sueldoBase * 20)/100);
       }else if(sueldoBase>20000 && sueldoBase <= 45000){
           sueldoConAumento += sueldoBase + ((sueldoBase * 10)/100);
       }else {
           sueldoConAumento += sueldoBase + ((sueldoBase * 5)/100);
       }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }

    public static void main(String[] args) {
        new CalcularAumento().calcularAumento();
    }

}