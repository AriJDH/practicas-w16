public class Main {

    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona1 = new Persona("Persona 1",15,"123455");
        Persona persona2= new Persona("Persona2",12,"12345",50,130);
        double imc = persona2.calcularIMC();
        if (persona2.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("No es mayor de edad");
        }
        System.out.println(persona2.toString());
    }
}
