import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Persona persona1;
        persona1 = new Persona();
        Persona persona2 = new Persona("Pamela", 25, "40401105");
        Persona persona3 = new Persona("Juan", 30, "34838244", 40, 1.75);
        //Persona persona4 = new Persona("Paola", 25); falta un parámetro no permite construir el objeto

        int calculodeIMC = persona3.calcularIMC();
        System.out.println(persona3.toString());
        boolean edad = persona3.esMayorDeEdad();

        System.out.println("De acuerdo a tu peso y altura estás en ");
        if (calculodeIMC == -1){
            System.out.println("Bajo peso");
        }else {
            if (calculodeIMC == 0){
                System.out.println("Peso saludable");
            }
            else {
                System.out.println("Sobrepeso");
            }
        }

        System.out.println("Y además queremos decirte que sos");

        if(edad) System.out.println("mayor de edad.");
        else {
            System.out.println("menor de edad.");
        }


    }
}
