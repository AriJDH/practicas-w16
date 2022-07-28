package vectoresYmatrices;

import java.util.Scanner;

//ingresar 5 sueldos en una sola variable con los datos.
public class Ejemplo2 {
    private Scanner entry;
    private int[] salary;

    public void salaryFunction() {
        entry = new Scanner(System.in);
        salary = new int[4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Ingrese el sueldo:");
            salary[i] = entry.nextInt();
        }
    }

    public void print() {
        for (int j = 0; j < salary.length; j++) {
            System.out.println(salary[j]);
        }
    }


    public static void main(String[] args) {
        Ejemplo2 ejemplo2 = new Ejemplo2(); //tengo que instanciar a la clase donde cree mis funciones.
        ejemplo2.salaryFunction();
        ejemplo2.print();
    }
}
