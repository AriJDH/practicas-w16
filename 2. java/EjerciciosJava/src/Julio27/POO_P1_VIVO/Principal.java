package Julio27.POO_P1_VIVO;

import Julio27.POO_P1_VIVO.Persona;

public class Principal {

    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona personaConInfoBasica = new Persona("Juan",30,"12345");
        Persona personaConTodaLaInfo = new Persona("Pepito",23,"45678",60,180);

        int valorIMC = personaConTodaLaInfo.calcularIMC();
        switch (valorIMC)
        {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }
        if (personaConTodaLaInfo.esMayorDeEdad())
        {
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("No es mayor de edad");
        }
        System.out.println(personaConTodaLaInfo);
    }

}
