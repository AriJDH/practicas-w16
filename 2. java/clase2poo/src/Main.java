public class Main {
    public static void main(String[] args) {
        Persona personaConstructor1 = new Persona();
        Persona personaConstructor2 = new Persona("Santiago", 19, "100087");
        Persona personaConstructor3 = new Persona("Santiago", "100087", 19, 62,1.81f);
        Persona personaExtra = new Persona("Santiago", 19,"");

        int indicadorIMC = personaConstructor3.calcularIMC();
        boolean mayorEdad = personaConstructor3.esMayorDeEdad();

        personaConstructor3.mostrarInfo();
        System.out.println();

        switch (indicadorIMC){
            case -1:
                System.out.println("La persona tiene peso bajo.");
                break;

            case 0:
                System.out.println("La persona tiene peso saludable.");
                break;

            case 1:
                System.out.println("La persona tiene sobrepeso.");
                break;
        }

        if(mayorEdad) System.out.println("Es mayor de edad");
        else System.out.println("Es menor de edad");
    }
}
