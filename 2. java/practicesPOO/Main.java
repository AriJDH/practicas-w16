package practicesPOO;

public class Main {

    public static void main(String[] args) {

        // Constructor vacio
        Person person = new Person();
        // Constructor con nombre, edad, dni
        Person person3Parameter = new Person("Mariana", 23, "23456");
        // Constructor con nombre, edad, dni, peso y altura
        Person personAllParameter = new Person("Pepe", 24, "3456", 62.8, 1.55);

        // Enviar solo nombre y edad
        // Se debe enviar el dni vacio porque igual es requerido dentro de los constructores definidos
        Person person2Parameter = new Person("Ruth", 25, "");

        // Imprimiendo la persona con todos los parametros, mayor de edad y el calculo de imc
        System.out.println("---------------");
        System.out.println( personAllParameter.toString());
        System.out.println("---------------");
        System.out.println( personAllParameter.isOlder(personAllParameter.age));
        System.out.println("---------------");
        Main.messageIMC(personAllParameter);
        System.out.println("---------------");
    }

    private static void messageIMC(Person person) {
        int resultIMC = person.caculateIMC(person.weight, person.height);

        System.out.println("Tu Índice de masa corporal (IMC) es: ");

        if(resultIMC == -1)
            System.out.println("Bajo peso");
        else if (resultIMC == 0)
            System.out.println("peso saludable");
        else
            System.out.println("Sobrepeso");
    }
}
