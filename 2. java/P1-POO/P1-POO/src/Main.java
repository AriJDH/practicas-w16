public class Main {
    public static void main(String[] args){
        System.out.println("Hola mundo");
        Persona personaSinDatos = new Persona();
        Persona personaConMinimosDatos = new Persona("Renato", 20, "3456878");
        Persona personaConTodosSusDatos = new Persona("Renata", 8, "1450899",3,2);
        //Persona noEsPersonaSegunNuestraClase = new Persona("Renato", 5);

        System.out.println("El IMC de Renata es: " +  personaConTodosSusDatos.IMC());
        System.out.println("¿Renata es o no mayor de edad? " + personaConTodosSusDatos.esMayorDeEdad() );
        System.out.println(personaConTodosSusDatos.toString());
    }
}

