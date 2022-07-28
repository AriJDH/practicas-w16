package ejercicio1;

//Ejercicio 3: creación de la clase Main
public class Main {
    public static void main(String[] args) {
        //Ejercicio 4: instanciación de la clase Persona
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Claudio Antolin", 39, "1234567-8");
        Persona persona3 = new Persona("Ryu Hayabusa", 36, "8765432-1",72.4, 1.83);

        //Instanciación errónea de un objeto de tipo Persona
        //Persona persona4 = new Persona("Ken Masters", 42);

        //Ejercicio 6: invocación de métodos de la clase
        String salidaIMC;
        String isMayorDeEdad;

        switch (persona3.calcularIMC()){
            case -1:
                salidaIMC = "Esta persona se encuentra bajo peso";
                break;
            case 0:
                salidaIMC = "Esta persona tiene un peso saludable";
                break;
            case 1:
                salidaIMC = "Esta persona tiene sobrepeso";
                break;
            default:
                salidaIMC = "No se ha podido calcular el IMC de esta persona";
        }

        if (persona3.esMayorDeEdad()){
            isMayorDeEdad = "Esta persona es mayor de edad";
        }
        else{
            isMayorDeEdad = "Esta persona es menor de edad";
        }

        System.out.println(persona3.toString()
        + salidaIMC + "\n"
        + isMayorDeEdad);
    }
}
