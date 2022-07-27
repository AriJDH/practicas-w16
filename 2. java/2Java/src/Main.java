public class Main {

    public static void main(String[] args)
    {
        Persona persona = new Persona("Pedro",  36,"16458612-7");
        Persona personaUno = new Persona("Hugo", "15988864-4");
        Persona personaDos = new Persona();

        System.out.println(persona.calcularIMC(102,1.86));
        System.out.println(persona.esMayorDeEdad());
        System.out.println(persona.toString());


    }
}
