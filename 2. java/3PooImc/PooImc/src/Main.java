//Ejercicio 3: creación de clase Main y método main

public class Main {

    public static void main(String[] args) {

        //Ejercicio 4: Creación de objetos

        System.out.println("******Personas creadas******");

        Persona personaConstructor1 = new Persona();
        System.out.println("Primer Constructor: " + personaConstructor1);

        Persona personaConstructor2 = new Persona("Yenny", 15,"DNI9874");
        System.out.println("Segundo Constructor: " + personaConstructor2);

        Persona personaConstructor3 = new Persona("José",17,"DNI1234",50,150.0);
        System.out.println("Tercer Constructor: " + personaConstructor3);

        //Ejercicio 5: No es posible la creación de este objeto debido a que en la clase Persona no hay un
        // constructor definido para los parámetros nombre y edad solamente, por lo que se genera error
       // Persona personaConstructor = new Persona("Mario",30);

        //Ejercicio 6: invocar métodos y dar resultados

        //Cálculo del IMC
        int imc = personaConstructor3.calcularIMC(personaConstructor3.peso, personaConstructor3.altura);

        String nivelDePeso;

        if (imc == -1){
            nivelDePeso = "Bajo Peso";
        } else if (imc == 0){
            nivelDePeso ="Peso Saludable";
        } else {//1
            nivelDePeso = "Sobrepeso";
        }

        //Cálculo de la edad
        boolean edadMayorOMenor = personaConstructor3.esMayorDeEdad(personaConstructor3.edad);
        String mayorOMenor;
        if(edadMayorOMenor){
            mayorOMenor = "es mayor de edad";
        } else {
            mayorOMenor = "es menor de edad";
        }

        //Mensajes para el usuario
        System.out.println();
        System.out.println("******Información de la Persona******");
        System.out.println(personaConstructor3.nombre + " es " + mayorOMenor + " y el cálculo de su IMC indica que tiene " + nivelDePeso);

        //Método toString
        System.out.println();
        System.out.println("******Datos completo de la Persona******");
        System.out.println(personaConstructor3.toString());

    }
}
