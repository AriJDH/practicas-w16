package pooP1Vivo;

public class Main {

    public static void main(String[] args) {

        Persona persona = new Persona();
        Persona persona1 = new Persona("Oliver",26,"123456");
        Persona persona2 = new Persona("Alejandra",22,"246810",64.7,1.68);

        System.out.println(persona2.toString());

        int imc = persona2.calcularIMC();

        switch (imc){
            case -1:
                System.out.println("Índice de masa corporal por debajo de 20, tiene un peso bajo");
                break;
            case 0:
                System.out.println("Índice de masa corporal entre 20 y 25, tiene un peso saludable");
                break;
            case 1:
                System.out.println("Índice de masa corporal mayor a 25, tiene sobrepeso");
                break;
        }

        if(persona2.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }

    }
}
