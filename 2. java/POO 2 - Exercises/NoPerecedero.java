/*
 * Crear la clase NoPerecedero, la misma va a tener un atributo llamado tipo, el mismo va a ser un String, crear setters, getters, constructor y método toString();
 *  en esta clase el método calcular() va a hacer exactamente lo mismo que en la clase Producto.
 */

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
