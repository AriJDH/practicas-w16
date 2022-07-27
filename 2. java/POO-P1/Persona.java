public class Persona {
   private String nombre;
   private int edad;
   private String dni;
   private int peso;
   private double altura;

   public Persona() {
      nombre = "";
      edad   = 0;
      dni    = "";
      peso   = 0;
      altura = 0;
   }

   public Persona(String nombre, int edad, String dni,int peso,double altura) {
      this.nombre = nombre;
      this.edad   = edad;
      this.dni    = dni;
      this.peso   = peso;
      this.altura = altura;
   }

   public Persona (String nombre, int edad, String dni){
      this.nombre = nombre;
      this.edad = edad;
      this.dni = dni;
   }

   public int calcularIMC() {
      double indice = peso / Math.pow(altura,2);

      if(indice < 20){
         return -1;
      }else if (indice <= 25 && indice >= 20){
         return 0;
      }else
      return 1;
   }

   public boolean esMayorDeEdad(){
      if (edad >= 18){
         return true;
      }else
      return false;
   }

   @Override
   public String toString() {
      return "Persona{" +
      "nombre='" + nombre + '\'' +
      ", edad=" + edad +
      ", dni='" + dni + '\'' +
      ", peso=" + peso +
      ", altura=" + altura +
      '}';
   }
}
