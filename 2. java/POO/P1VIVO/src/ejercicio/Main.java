package ejercicio;

public class Main {

    public static void main(String[] args) {
        Persona persona0 = new Persona();
        System.out.println(persona0.toString());
        System.out.println("--------------------------------\n");

        Persona persona1 = new Persona("Guille", "5140", 33);
        System.out.println(persona1.toString());
        System.out.println("--------------------------------\n");

        Persona persona2 = new Persona("Pedro","1234", 17,45.32,1.20);
        System.out.println(persona2.toString());
        System.out.println("Es mayor de edad: " + (persona2.esMayorDeEdad() ? "Si":"No"));

        int persona2IMC = persona2.calcularIMC();
        String tipoPeso;

        if (persona2IMC == -1){
            tipoPeso = "Bajo Peso";
        }else if (persona2IMC == 0){
            tipoPeso = "Peso Saludable";
        }else{
            tipoPeso = "Sobrepeso";
        }
        System.out.println("IMC: " + tipoPeso);
        System.out.println("--------------------------------\n");
    }

}
