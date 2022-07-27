public class Main {

   public static void main(String[] args) {
      Persona personaVacia = new Persona();
      Persona personaConConstructorCompleta =  new Persona ("Alejandro",36,"36666999",96,1.95);
      Persona personaConstructorIncompleto =  new Persona ("Denise",30,"36666999");

      int valorIMC = personaConConstructorCompleta.calcularIMC();

      switch (valorIMC) {
         case -1:
         System.out.println("Bajo peso");
         break;
         case 0:
         System.out.println("Peso saludable");
         case 1:
         System.out.println("Sobrepeso");
         default:
         break;
      }

      if(personaConConstructorCompleta.esMayorDeEdad()){
         System.out.println("Es mayor de edad");
      }else{
         System.out.println("No es mayor de edad");
      }

      System.out.println(personaConConstructorCompleta);
   }
}
