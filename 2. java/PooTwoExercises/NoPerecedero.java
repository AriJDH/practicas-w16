
package PooTwoExercises;

public class NoPerecedero extends Producto{
    private String tipo;

    /*
     * CONSTRUCTOR
     */

    public NoPerecedero(String nombre, int precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }


    /*
     * GETTERS
     */

     public String getTipo(){
        return tipo;
     }

     /*
      * SETTERS
      */

      public void setTipo(String tipo){
        this.tipo = tipo;
      }
}
