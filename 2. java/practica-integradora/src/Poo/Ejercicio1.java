package Poo;

public class Ejercicio1 {

    public static void main(String[] args){
        Persona persona = new Persona();

        Persona personaData = new Persona("Equipo11", 20, 1000);

        Persona personaComplete = new Persona("Equipo11",20,1000,70,1.70F);

        int imc = personaComplete.calcularMC();

        if (personaData.esMayorEdad()){
            System.out.println("Es mayor de edad");
        }

        switch (imc){
            case -1:
                System.out.println("Por debajo del peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;

        }

    }
}
