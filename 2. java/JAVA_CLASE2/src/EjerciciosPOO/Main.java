package EjerciciosPOO;

public class Main {

    public static void main(String[] args){
        double imc;
        boolean mayor;
        String resumen;
        Persona persona = new Persona();

        Persona Ana = new Persona("frank", "31", "1065656886", 67d, 1.88);

        Persona persona2 = new Persona("ana", "29", "1065656886");

        imc = Ana.calcularIMC();
        mayor = Ana.esMayorDeEdad();
        System.out.println(resumen = Ana.toString(imc, mayor));

    }

}
