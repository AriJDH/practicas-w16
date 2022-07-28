public class Main {

    public static void main(String[] args) {
        Persona individuo1 = new Persona();
        Persona individuo2 = new Persona("José", 24, "19099321");
        Persona individuo3 = new Persona("María",17,"98712343",62.5,1.68);
        // Persona individuo4 = new Persona("Marcos", 33);

        short saludIMC = individuo3.calcularIMC();

        String stringEdad;
        if(individuo3.esMayorDeEdad())
            stringEdad = "Es mayor de edad.";
        else stringEdad = "No es mayor de edad.";


        System.out.println(individuo3.toString());
        System.out.println(stringEdad);

        switch(saludIMC){
            case -1:
                System.out.println("Su IMC está por debajo de lo saludable.");
                break;
            case 1:
                System.out.println("Su IMC está por encima de lo saludable.");
                break;
            case 0:
            default:
                System.out.println("Su IMC es saludable.");
        }
    }

}
