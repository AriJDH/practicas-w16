public class Main {
    public static void main(String[] args) {
        //Constructores personas
        Person personaUno = new Person();
        Person personaDos = new Person("Anggy", 24, "1073565432");
        Person personaTres = new Person("Arvey", 22, "1073565432", 80, 1.80);

        //Person personaCuatro = new Person("Anggy", 24); Constructor sin parametros completos

        //Calcular IMC
        System.out.println("Su indice de masa corporal dio: " + personaTres.cacularIMC());
        System.out.println("Recuerde que -1 es bajo de peso, 0 es peso saludable, 1 es sobrepeso");

        //Es mayor de edad
        System.out.println(personaTres.esMayorDeEdad() == true ? "Es mayor de edad" : "No es mayor de edad" );

    }
}
