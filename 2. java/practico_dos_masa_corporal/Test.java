

public class Main {


    public static void main(String[] args) {

        Persona one = new Persona();
        Persona two = new Persona("joaco",29,"51179057",80,150);
        Persona three = new Persona("carlos",29,"51179057",80,150);

        if(three.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }


        if(three.calcularIMC() == 1){
            System.out.println("Sobrepeso);
        }

        if(three.calcularIMC() == -1){
            System.out.println("Bajo peso);
        }
        if(three.calcularIMC() == 0){
            System.out.println("Peso saludable");
        }


    }


}
