public class Persona {

    private String name;
    private int age;
    private String dni;
    private double weight;
    private double heigh;


    public Persona() {
    }

    public Persona(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Persona(String name, int age, String dni, double weight, double heigh) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.heigh = heigh;
    }

    public double calcularIMC(){
        if(this.weight/this.heigh *this.heigh< 20 )
            return -1;
        if(this.weight/this.heigh*this.heigh >= 20 && this.weight/this.heigh <= 25 )
            return 0;
        if(this.weight/this.heigh*this.heigh>25)
            return 1;

    }

    public boolean esMayorDeEdad(){
        return this.age > 18;
    }

    @Override
    public java.lang.String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", weight=" + weight +
                ", heigh=" + heigh +
                '}';
    }





}