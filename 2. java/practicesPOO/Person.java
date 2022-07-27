package practicesPOO;

import java.util.Optional;

public class Person {

    public String name;
    public int age;
    public String dni;
    public double weight;
    public double height;

    public Person() {

    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public int caculateIMC(double weight, double height) {

        int resultIMC = (int) (weight/(height*height));

        if(resultIMC < 20)
            return -1;
        else if (resultIMC <= 25)
            return 0;
        else
            return 1;
    }

    public String isOlder(int age) {
        if (age < 18)
            return "No es mayor de edad";
        else
            return "Es mayor de edad";
    }

    @Override
    public String toString() {
        return "Datos enviados:" +
                "\n -name= " + name +
                "\n -age= " + age +
                "\n -dni= " + dni +
                "\n -weight= " + weight +
                "\n -height= " + height;
    }
}
