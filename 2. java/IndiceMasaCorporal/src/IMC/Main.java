package IMC;

public class Main {

    public static void main(String[] args) {
        Persona p_empty = new Persona();
        Persona p_data = new Persona("German", 30, "4986786-5");
        Persona p_full = new Persona("German", 30, "4986786-5", 80.2, 1.80);

        System.out.println(p_full.toString());

        System.out.println("---------------------------------------");

        int imc = p_full.calcularIMC();

        switch(imc){
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

        System.out.println("---------------------------------------");

        if(p_full.esMayorDeEdad())
            System.out.println("Es mayor de edad");
        else
            System.out.println("Es menor de edad");

        System.out.println("---------------------------------------");
    }

}
