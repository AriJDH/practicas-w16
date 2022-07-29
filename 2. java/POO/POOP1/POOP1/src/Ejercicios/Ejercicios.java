package Ejercicios;

public class Ejercicios {
    public static void main(String[] args) {//Ejercicio 3
        //Ejercicio 4
        Person persona = new Person();
        Person persona1 = new Person("Gabriel", 25, "19524949-0");
        Person persona2 = new Person("Gabriel", 25, "19524949-0", 9.9, 1.83);

        double imc = persona.calcularImc(persona2.height, persona2.height);

        System.out.println("Nombre: " + persona2.name);
        System.out.println("Edad: " + persona2.age);
        System.out.println("DNI: " + persona2.dni);
        System.out.println("Peso: " + persona2.weight);
        System.out.println("Altura: " + persona2.height);
        System.out.println("IMC: " + imc);
        if (imc == 0) {
            System.out.println("IMC refleja que se encuentra con peso saludable");
        }
        if (imc == -1) {
            System.out.println("IMC refleja que se encuentra bajo peso");
        }
        if (imc == 1) {
            System.out.println("IMC refleja que se encuentra sobre peso");
        }
        if (persona2.esMayorDeEdad(persona2.age)) {
            System.out.println("Es Mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }

    }

    static class Person {
        //attributes Ejercicio 1
        String name;
        int age;
        String dni;
        double weight;//peso
        double height;//altura

        //Constructores Ejercicio 2
        public Person() {

        }

        public Person(String name1, int age1, String dni1) {
            this.name = name1;
            this.age = age1;
            this.dni = dni1;

        }

        public Person(String name1, int age1, String dni1, double weight, double height) {
            this.name = name1;
            this.age = age1;
            this.dni = dni1;
            this.weight = weight;
            this.height = height;
        }

        //Metodo Ejericio 5
        public double calcularImc(Double weight, double height) {
            double imc = weight / Math.pow(height, 2);
            int resImc = 0;
            if (imc < 20) {
                resImc = -1;
            }
            if (imc >= 20 && imc <= 25) {
                resImc = 0;
            }
            if (imc > 25) {
                resImc = 1;
            }
            return resImc;
        }

        public boolean esMayorDeEdad(int age) {
            if (age >= 18) {
                return true;
            } else {
                return false;
            }

        }


    }

}

