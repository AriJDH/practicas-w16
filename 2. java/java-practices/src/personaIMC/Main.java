package personaIMC;

/*
 * Ejercicio > Modulo 5: Java > POO-P1-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
public class Main {
    public static void main(String[] args){
        //Persona persona1 = new Persona();
        //Persona persona2 = new Persona("Gonzalo Nahuel", 29, "12.345.678");
        Persona persona3 = new Persona("Gonzalo Nahuel", 29, "12.345.678", 70, 1.70);

        String resultadoIMC;
        switch (persona3.calcularIMC()){
            case -1: resultadoIMC = "Bajo peso (por debajo de 20).";
                break;
            case 0: resultadoIMC = "Peso saludable (entre 20 y 25 inclusive).";
                break;
            case 1: resultadoIMC = "Sobrepeso (mayor de 25).";
                break;
            default: resultadoIMC = "";
                break;
        }

        System.out.println("DATOS DE LA PERSONA");
        System.out.println("> " + persona3); // Llama implicitamente al toString()
        System.out.println("> Índice de masa corporal (IMC): " + resultadoIMC);
        System.out.println("> ¿Es mayor de edad?: " + (persona3.esMayorDeEdad() ? "SI." : "NO."));
    }
}
