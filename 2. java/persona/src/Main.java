public class Main {
    public static void main(String[] args) {
      Persona pesronsa1 = new Persona();
      Persona persona2  = new Persona("Sebastian",22,"203862369");
      Persona persona3  = new Persona("Josse",22,"203862369",116.0,1.80);
        System.out.println(persona3.toString());
      System.out.println(persona3.calcularIMC());
        if(persona3.esMayoDeEdad()){
            System.out.println("Es mayor de edad");
        }
        else {
            System.out.println("Es menor de edad");
        }

    }
}

