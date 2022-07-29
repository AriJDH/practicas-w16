public class Distribuidora {
   public static void main(String[] args) {

      Producto productos[] = new Producto[3];

      productos[0] = new Perecedero("Carne", 7.5, 1);
      productos[1] = new NoPerecedero("Conserva", 4.2, "Congelado");
      productos[2] = new Producto("Pollo", 6.1);

      for (Producto producto : productos) {
         System.out.println(
               producto.calcular(5));
      }
   }
}
