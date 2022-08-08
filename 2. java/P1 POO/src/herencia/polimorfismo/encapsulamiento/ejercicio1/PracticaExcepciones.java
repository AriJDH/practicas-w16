package herencia.polimorfismo.encapsulamiento.ejercicio1;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void cociente(double resultado){
        try {
            if (a==0) throw new IllegalArgumentException("No se puede dividir por cero");
            resultado = this.b/this.a;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("Programa finalizado");
        }
    }

}
