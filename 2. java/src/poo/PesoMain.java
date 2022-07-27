package poo;

public class PesoMain {

    public static void main(String[]args){
        Persona persona = new Persona();
        Persona personaConTresArgumentos = new Persona("Gilberto",26,"2563984-2");
        Persona personaCompleta = new Persona("Gilberto",26,"2563984-2",98.5,1.74);

        if(personaCompleta.esMayorDeEdad()){
            System.out.println(personaCompleta.getNombre()+ " Eres Mayor de edad!");
        } else{
            System.out.println(personaCompleta.getNombre()+ " Eres peque aun!!");

        }

        if(personaCompleta.calcularIMC() == -1) System.out.println(personaCompleta.getNombre()+" Te encuentras con Bajo Peso");
        if(personaCompleta.calcularIMC() == 0) System.out.println(personaCompleta.getNombre()+" Te encuentras con Peso saludable");
        if(personaCompleta.calcularIMC() == 1) System.out.println(personaCompleta.getNombre()+" Te encuentras con Sobrepeso");

    }
}
