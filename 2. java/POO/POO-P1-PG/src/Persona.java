public class Persona {
    private int id;
    private String name;
    private int age;

    public Persona(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Persona(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void mostrarPersona(){
        System.out.println(id + " " + name + " " + age);
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona(1, "Pamela");
        Persona persona2 = new Persona(1, "Pamela", 25);
        persona1.mostrarPersona();
        persona2.mostrarPersona();

    }
}
